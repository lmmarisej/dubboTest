package org.lmmarise.seata.web.config;

import com.alibaba.cloud.seata.SeataProperties;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/31 4:27 下午
 */
@Configuration
@EnableConfigurationProperties({SeataProperties.class})
public class SeataAutoConfig {

    private final ApplicationContext applicationContext;
    private final SeataProperties seataProperties;

    public SeataAutoConfig(SeataProperties seataProperties, ApplicationContext applicationContext){
        this.applicationContext=applicationContext;
        this.seataProperties=seataProperties;
    }

    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        String applicationName = this.applicationContext.getEnvironment().getProperty("spring.application.name");
        String txServiceGroup = this.seataProperties.getTxServiceGroup();
        if (StringUtils.isEmpty(txServiceGroup)) {
            txServiceGroup = applicationName + "-seata-service-group";
            this.seataProperties.setTxServiceGroup(txServiceGroup);
        }
        return new GlobalTransactionScanner(applicationName, txServiceGroup);
    }
}
