package com.cloud.hystrix.ribbion;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author doalso
 */
@SpringCloudApplication
public class HystrixRibbionApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main( String[] args ) {
        SpringApplication.run(HystrixRibbionApplication.class, args);
    }
}
