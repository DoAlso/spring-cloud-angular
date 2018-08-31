package com.cloud.sample.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTest {

    @Bean
    public User getUser(){
        return new User();
    }

}
