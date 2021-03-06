package org.lmmarise.seata.repo;

import com.alibaba.cloud.seata.GlobalTransactionAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/30 11:07 上午
 */
@SpringBootApplication(exclude = GlobalTransactionAutoConfiguration.class)
public class RepoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepoProviderApplication.class, args);
    }
}
