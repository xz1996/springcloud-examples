package com.springcloud.microservice.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jerry Xie
 * @date 3/1/2018 14:56
 */

@RestController("ConsumerController")
public class RibbonConsumerController {

    private static final String SERVICE_PROVIDER_NAME = "eureka-client";

    private static final String ENDPOINT = "/discoveryClient";

    private static final String URL = "http://" + SERVICE_PROVIDER_NAME + ENDPOINT;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbonConsumer")
    public String ribbonConsumeService() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        return responseEntity.getBody();
    }
}
