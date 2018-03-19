package com.springcloud.microservice.feignconsumer.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Jerry Xie
 * @date 3/5/2018 10:36
 */
@Slf4j
@Component
public class FeignConsumerFallback implements FallbackFactory<FeignConsumerService> {

    @Override
    public FeignConsumerService create(Throwable cause) {
        return new FeignConsumerService() {
            @Override
            public String discoveryClient() {
                String msg = "discoveryClient fallback : " + cause;
                log.warn(msg);
                return msg;
            }

            @Override
            public String provider(String name) {
                String msg = "provider fallback. name is" + name + " : " + cause;
                log.warn(msg);
                return msg;
            }

            @Override
            public String provider2(String name, String token) {
                String msg = "provider2 fallback. name is "+ name + " and token is" + token + " : " + cause;
                log.warn(msg);
                return msg;
            }
        };
    }
}
