package org.lmmarise.seata.web;

import com.alibaba.cloud.seata.GlobalTransactionAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/30 11:49 上午
 */
@SpringBootApplication(exclude = GlobalTransactionAutoConfiguration.class)
public class SampleRestWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleRestWebApplication.class, args);
    }
}
