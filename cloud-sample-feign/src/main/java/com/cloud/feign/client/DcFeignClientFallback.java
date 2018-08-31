package com.cloud.feign.client;

import org.springframework.stereotype.Component;

@Component
public class DcFeignClientFallback implements DcFeignClient {

    @Override
    public String consumer() {
        return "hello fallback";
    }
}
