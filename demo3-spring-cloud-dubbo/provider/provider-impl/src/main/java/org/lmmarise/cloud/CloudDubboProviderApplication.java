package org.lmmarise.cloud;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/28 5:58 下午
 */
@DubboComponentScan
@SpringBootApplication
public class CloudDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDubboProviderApplication.class, args);
    }
}
