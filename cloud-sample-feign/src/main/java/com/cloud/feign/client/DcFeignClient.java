package com.cloud.feign.client;

import com.cloud.feign.client.configuration.DcClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author doalso
 * springcloud 允许开发人员通过@FeignClient的
 * configuration配置完全控制每一个FeignClient
 * 的私有配置
 */
@FeignClient(name = "sample-hystrix",fallbackFactory = DcFeignClientFallbackFactory.class,configuration = DcClientConfiguration.class)
public interface DcFeignClient {

    @GetMapping("/dc")
    String consumer();
}
