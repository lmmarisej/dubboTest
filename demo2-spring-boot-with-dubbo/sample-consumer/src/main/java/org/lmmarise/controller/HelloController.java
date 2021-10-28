package org.lmmarise.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.lmmarise.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/28 12:42 下午
 */
@RestController
public class HelloController {

    @Reference(url = "dubbo://127.0.0.1:20880/org.lmmarise.service.HelloService")
    private HelloService helloService;

    @GetMapping("/say")
    public String sayHello(){
        return helloService.sayHello("Cxk");
    }
}
