package org.lmmarise.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/28 12:27 下午
 */
@DubboService
public class HelloServiceImpl implements HelloService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s]：Hello,%s", serviceName, name);
    }
}
