package org.lmmarise.seata.repo.config;

import com.alibaba.cloud.seata.SeataProperties;
import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.commons.lang3.StringUtils;
import org.lmmarise.seata.repo.entity.Repo;
import org.lmmarise.seata.repo.repository.RepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Properties;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/31 4:17 下午
 */
@EnableJpaRepositories(basePackageClasses = RepoRepository.class)
@EnableTransactionManagement
@EnableConfigurationProperties({SeataProperties.class, HibernateProperties.class})
@Configuration
public class SeataAutoConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Resource
    private JpaProperties jpaProperties;
    @Resource
    private HibernateProperties hibernateProperties;

    private final ApplicationContext applicationContext;
    private final SeataProperties seataProperties;

    public SeataAutoConfig(SeataProperties seataProperties, ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.seataProperties = seataProperties;
    }

    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        return druidDataSource;
    }

    @Bean
    public DataSourceProxy dataSourceProxy(DruidDataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSourceProxy dataSourceProxy) {
        return new DataSourceTransactionManager(dataSourceProxy);
    }

    /**
     * JPA 配置
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSourceProxy dataSourceProxy) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSourceProxy);
        entityManagerFactoryBean.setPackagesToScan(Repo.class.getPackage().getName());
        Map<String, Object> propertiesMap = hibernateProperties
                .determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
        Properties properties = new Properties();
        properties.putAll(propertiesMap);
        entityManagerFactoryBean.setJpaProperties(properties);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManagerFactoryBean;
    }

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        String applicationName = this.applicationContext.getEnvironment().getProperty("spring.application.name");
        String txServiceGroup = this.seataProperties.getTxServiceGroup();
        if (StringUtils.isEmpty(txServiceGroup)) {
            txServiceGroup = applicationName + "-seata-service-group";
            this.seataProperties.setTxServiceGroup(txServiceGroup);
        }
        return new GlobalTransactionScanner(applicationName, txServiceGroup);
    }
}
