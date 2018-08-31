package com.cloud.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;


/**
 * @author doalso
 */
@MapperScan(basePackages = {"com.cloud.security.dao"})
@SpringCloudApplication
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
