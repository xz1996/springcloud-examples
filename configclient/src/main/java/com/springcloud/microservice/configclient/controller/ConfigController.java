package com.springcloud.microservice.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry Xie
 * @date 3/7/2018 13:22
 */

@RefreshScope
@RestController
public class ConfigController {

    @Autowired
    private Environment environment;

    @Value("${branch}")
    private String branch;

    @GetMapping("/env")
    public String getEnv() {
        // get the config property from config server
        System.out.println(branch);
        return environment.getProperty("application.name", "undefined");
    }
}
