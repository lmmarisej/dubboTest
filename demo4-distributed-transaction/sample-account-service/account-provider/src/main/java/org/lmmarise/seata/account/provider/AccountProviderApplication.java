package org.lmmarise.seata.account.provider;

import com.alibaba.cloud.seata.GlobalTransactionAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:13 下午
 */
@SpringBootApplication(exclude = {GlobalTransactionAutoConfiguration.class})
public class AccountProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountProviderApplication.class, args);
    }
}
