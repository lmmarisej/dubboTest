package org.lmmarise.cloud.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.lmmarise.cloud.service.IHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/28 5:55 下午
 */
@RestController
public class HelloController {

    @DubboReference(mock = "org.lmmarise.cloud.service.MockHelloService", cluster = "failfast")  // 失败策略及失败调用本地实现
    private IHelloService iHelloService;

    @GetMapping("/say")
    public String sayHello() {
        return iHelloService.sayHello("Cxk");
    }
}
