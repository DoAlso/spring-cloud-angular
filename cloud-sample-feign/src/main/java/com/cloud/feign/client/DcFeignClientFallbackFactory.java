package com.cloud.feign.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author doalso
 * 该类是用来保护当请求
 * 失败时，作为降级策略使用的
 */
@Component
public class DcFeignClientFallbackFactory implements FallbackFactory<DcFeignClient> {

    @Override
    public DcFeignClient create(Throwable throwable) {
        return () -> "hello fallback"+throwable.getMessage();
    }
}
