package com.cloud.configservice.common;

import com.cloud.configservice.service.PersistenceService;
import com.cloud.configservice.service.impl.DbPersistenceService;
import com.cloud.configservice.service.impl.GitPersistenceService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ConfigCoreConfiguration
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/14 15:26
 */
@Configuration
@EnableConfigurationProperties(ConfigCoreProperties.class)
public class ConfigCoreConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "config", name = "repository", havingValue = "db")
    public PersistenceService persistenceDbService() {
        return new DbPersistenceService();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "config", name = "repository", havingValue = "git")
    public PersistenceService persistenceGitService() {
        return new GitPersistenceService();
    }
}
