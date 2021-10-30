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