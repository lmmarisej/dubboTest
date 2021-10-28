package org.lmmarise.dubbo.spi;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/26 10:15 下午
 */
public class MysqlDriver implements Driver {

    @Override
    public String connect() {
        return "连接Mysql数据库";
    }
}
