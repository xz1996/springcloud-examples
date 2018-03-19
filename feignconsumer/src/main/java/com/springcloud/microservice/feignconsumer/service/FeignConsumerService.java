package com.springcloud.microservice.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Jerry Xie
 * @date 3/2/2018 16:32
 */
@FeignClient(value = "${service.provider.name[0]}", fallbackFactory = FeignConsumerFallback.class)
public interface FeignConsumerService {

    @GetMapping("/discoveryClient")
    String discoveryClient();

    @GetMapping("/provider1")
    String provider(@RequestParam("name") final String name);

    @GetMapping("/provider2")
    String provider2(@RequestParam("name") final String name,
                     @RequestHeader("token") final String token);
}
