package org.lmmarise.cloud.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/28 6:03 下午
 */
@DubboService(loadbalance = "rundrobin")
public class HelloServiceImpl implements IHelloService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s]：Hello, %s", serviceName, name);
    }
}
