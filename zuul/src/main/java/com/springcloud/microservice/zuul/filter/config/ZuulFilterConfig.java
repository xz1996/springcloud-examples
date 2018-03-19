package com.springcloud.microservice.zuul.filter.config;

import com.springcloud.microservice.zuul.filter.PreFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jerry Xie
 * @date 3/6/2018 17:01
 */
@Configuration
public class ZuulFilterConfig {

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
}
