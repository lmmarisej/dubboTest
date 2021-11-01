## demo4-distributed-transaction

### 搭建 nacos

1. 启动：docker run --name nacos-standalone -e MODE=standalone -p 8848:8848 -d nacos/nacos-server:latest
2. 管理端：http://127.0.0.1:8848/nacos/index.html，用户密码：nacos

### 搭建 seata
1. 下载：https://github.com/seata/seata/releases/download/v1.0.0/seata-server-1.0.0.zip
2. 修改配置：
    ```conf
    # seata 注册地址
    registry {
      # file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
      type = "nacos"
    
      nacos {
        serverAddr = "localhost:8848"
        namespace = ""
        cluster = "default"
      }
    }
    
    # 用于配置 seata 服务地址
    config {
      # file、nacos 、apollo、zk、consul、etcd3
      type = "nacos"
    
      nacos {
        serverAddr = "localhost:8848"
        namespace = ""
      }
    }
    ```
3. 启动：bin/seata-server.sh

### 启动项目
1. 默认情况下，spring-boot会自动加载data.sql或data-${platform}.sql文件来初始化数据库。通过 initialization-mode: always，任何类型数据库都初始化。
   > @InitDataSource({"data.sql"})注解，自动初始化。
2. 访问测试：Post http://127.0.0.1:8080/order 
   > {"userId": 10001, "productCode": "GP20200202001", "name":"键盘", "count":1, "amount": 400}
   
   > {"userId": 10001, "productCode": "GP20200202002", "name":"抱枕", "count":1, "amount": 400}

## demo5-rocketmq
### 创建Rocketmq
name server
```shell
mkdir -p /Users/lmmarise.j/docker/rocketmq/data/namesrv/logs /Users/lmmarise.j/docker/rocketmq/data/namesrv/store

docker run -d \
--restart=always \
--name rmqnamesrv \
-p 9876:9876 \
-v /Users/lmmarise.j/docker/rocketmq/data/namesrv/logs:/root/logs \
-v /Users/lmmarise.j/docker/rocketmq/data/namesrv/store:/root/store \
-e "MAX_POSSIBLE_HEAP=100000000" \
rocketmqinc/rocketmq \
sh mqnamesrv
```

broker
```shell
mkdir -p  /Users/lmmarise.j/docker/rocketmq/data/broker/logs   /Users/lmmarise.j/docker/rocketmq/data/broker/store /Users/lmmarise.j/docker/rocketmq/conf

sub touch /Users/lmmarise.j/docker/rocketmq/conf/broker.conf
# 所属集群名称，如果节点较多可以配置多个
brokerClusterName = DefaultCluster
#broker名称，master和slave使用相同的名称，表明他们的主从关系
brokerName = broker-a
#0表示Master，大于0表示不同的slave
brokerId = 0
#表示几点做消息删除动作，默认是凌晨4点
deleteWhen = 04
#在磁盘上保留消息的时长，单位是小时
fileReservedTime = 48
#有三个值：SYNC_MASTER，ASYNC_MASTER，SLAVE；同步和异步表示Master和Slave之间同步数据的机制；
brokerRole = ASYNC_MASTER
#刷盘策略，取值为：ASYNC_FLUSH，SYNC_FLUSH表示同步刷盘和异步刷盘；SYNC_FLUSH消息写入磁盘后才返回成功状态，ASYNC_FLUSH不需要；
flushDiskType = ASYNC_FLUSH
# 设置broker节点所在服务器的ip地址
brokerIP1 = 物理机地址ifconfig

# 就是 4.4.0 查看版本：docker image inspect rocketmqinc/rocketmq:latest|grep -i version
docker run -d  \
--restart=always \
--name rmqbroker \
--link rmqnamesrv:namesrv \
-p 10911:10911 \
-p 10909:10909 \
-v  /Users/lmmarise.j/docker/rocketmq/data/broker/logs:/root/logs \
-v  /Users/lmmarise.j/docker/rocketmq/data/broker/store:/root/store \
-v /Users/lmmarise.j/docker/rocketmq/conf/broker.conf:/opt/rocketmq-4.4.0/conf/broker.conf \
-e "NAMESRV_ADDR=namesrv:9876" \
-e "MAX_POSSIBLE_HEAP=200000000" \
rocketmqinc/rocketmq \
sh mqbroker -c /opt/rocketmq-4.4.0/conf/broker.conf 
```

rockermq-console
```shell
# 192.168.68.175 ifconfig
docker run -d \
--restart=always \
--name rmqadmin \
-e "JAVA_OPTS=-Drocketmq.namesrv.addr=192.168.68.175:9876 \
-Dcom.rocketmq.sendMessageWithVIPChannel=false -Duser.timezone='Asia/Shanghai'" \
-v /etc/localtime:/etc/localtime \
-p 9999:8080 \
pangliang/rocketmq-console-ng
```

开放指定端口 linux
```shell
firewall-cmd --permanent --zone=public --add-port=9876/tcp
firewall-cmd --permanent --zone=public --add-port=10911/tcp
# 立即生效
firewall-cmd --reload
```

