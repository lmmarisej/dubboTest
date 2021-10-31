package org.lmmarise.seata.order;

import com.alibaba.cloud.seata.GlobalTransactionAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:13 下午
 */
@SpringBootApplication(exclude = GlobalTransactionAutoConfiguration.class)
public class OrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class, args);
    }
}
