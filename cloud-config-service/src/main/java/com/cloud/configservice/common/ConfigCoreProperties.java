package com.cloud.configservice.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName ConfigCoreProperties
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/14 15:27
 */
@Data
@ConfigurationProperties("config")
public class ConfigCoreProperties {
    /**
     * 默认的label名称
     */
    private String defaultLabel = "master";

    private String repository = "git";
}
