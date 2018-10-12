package com.cloud.provider;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author doalso
 */
@EnableScheduling
@SpringCloudApplication
@ComponentScan(basePackages = {"com.txmq"})
public class ProviderApplication {

    public static void main( String[] args ) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
