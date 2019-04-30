package com.cloud.configservice.common;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 程序猿DD/翟永超 on 2018/5/2.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */

@Configuration
@EnableConfigurationProperties({ConfigGitProperties.class})
public class ConfigGitConfiguration {

}
