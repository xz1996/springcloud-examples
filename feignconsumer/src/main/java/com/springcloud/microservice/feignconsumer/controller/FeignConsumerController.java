package com.springcloud.microservice.feignconsumer.controller;

import com.springcloud.microservice.feignconsumer.service.FeignConsumerService;
import com.springcloud.microservice.feignconsumer.utility.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry Xie
 * @date 3/2/2018 16:39
 */
@Slf4j
@RestController
public class FeignConsumerController {

    @Autowired
    private FeignConsumerService discoveryClientService;

    @GetMapping("/feignConsumer")
    public String feignConsumer() {
        return discoveryClientService.discoveryClient();
    }

    @GetMapping("/fc")
    public String fc() {
        return discoveryClientService.provider2("xz", "bear token");
    }
}
