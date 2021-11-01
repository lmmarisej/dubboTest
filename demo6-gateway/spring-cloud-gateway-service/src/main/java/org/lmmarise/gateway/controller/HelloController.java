package org.lmmarise.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 9:34 下午
 */
@RestController
public class HelloController {

    @GetMapping("/say")
    public String sayHello() {
        return "[spring-cloud-gateway-service]:say Hello";
    }
}
