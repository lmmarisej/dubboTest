package org.lmmarise.cloud.service;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/28 5:55 下午
 */
public class MockHelloService implements IHelloService {

    @Override
    public String sayHello(String name) {
        return "远程服务器异常，这是降级数据";
    }
}
