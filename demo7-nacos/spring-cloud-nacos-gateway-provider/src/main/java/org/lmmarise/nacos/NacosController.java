package org.lmmarise.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 11:54 下午
 */
@RestController
public class NacosController {

    @Value("${provider}")
    private String provider;

    @GetMapping("/say")
    public String sayHello() {
        return "[spring-cloud-nacos-gateway-provider][" + provider + "]:sayHello";
    }
}
