package com.springcloud.microservice.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry Xie
 * @date 3/1/2018 11:00
 */

@RestController
public class DiscoveryClientController {

    @GetMapping("/discoveryClient")
    public String discoveryClient() {
        String serviceStr = "Services:" + Thread.currentThread().getName();
        System.out.println(serviceStr);
        return serviceStr;
    }

    @GetMapping("/provider1")
    public String provider(@RequestParam("name") final String name) {
        return "Hello " + name;
    }

    @GetMapping("/provider2")
    public String provider(@RequestParam("name") final String name,
                           @RequestHeader("token") final String token) {
        return name + "'s token is : " + token;
    }
}
