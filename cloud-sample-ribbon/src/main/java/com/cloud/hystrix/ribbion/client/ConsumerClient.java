package com.cloud.hystrix.ribbion.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author doalso
 */
@Component
public class ConsumerClient {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return restTemplate.getForObject("http://sample-provider/dc", String.class);
    }

    public String fallback() {
        return "fallback";
    }
}
