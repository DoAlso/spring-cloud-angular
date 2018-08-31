package com.cloud.feign.controller;

import com.cloud.feign.client.DcFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author doalso
 */
@RestController
public class DcController {

    @Resource
    private DcFeignClient dcFeignClient;

    @GetMapping("/consumer")
    public String dc() {
        return dcFeignClient.consumer();
    }
}
