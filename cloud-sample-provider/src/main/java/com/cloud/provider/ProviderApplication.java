package com.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author doalso
 */
@EnableScheduling
@SpringCloudApplication
public class ProviderApplication {

    public static void main( String[] args ) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
