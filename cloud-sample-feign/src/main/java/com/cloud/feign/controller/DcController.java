package com.cloud.feign.controller;

import com.cloud.feign.client.DcFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author doalso
 */
@RefreshScope
@RestController
public class DcController {

    @Resource
    private DcFeignClient dcFeignClient;
    @Value("${author.name}")
    private String name;
    @GetMapping("/consumer")
    public String dc() {
        return dcFeignClient.consumer();
    }

    @GetMapping("/getName")
    public String getName(){
        return name;
    }
}
