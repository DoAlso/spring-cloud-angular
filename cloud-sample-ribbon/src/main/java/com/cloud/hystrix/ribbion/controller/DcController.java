package com.cloud.hystrix.ribbion.controller;

import com.cloud.hystrix.ribbion.client.ConsumerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author doalso
 */
@RestController
public class DcController {

    @Autowired
    private ConsumerClient consumerClient;

    @GetMapping("/consumer")
    public String dc() {
        return consumerClient.consumer();
    }
}
