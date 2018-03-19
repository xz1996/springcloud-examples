package com.springcloud.microservice.ribbonconsumer.config;

import com.springcloud.microservice.ribbonconsumer.exceptionHandler.RestTemplateResponseErrorHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;


/**
 * @author Jerry Xie
 * @date 3/1/2018 14:49
 */
@Configuration("RestTemplateConfig")
public class RestTemplateConfig {

    private static final int CONNECT_TIMEOUT = 15000;
    private static final int READ_TIMEOUT = 15000;

    @Bean
    @LoadBalanced
    @ConditionalOnMissingBean(RestOperations.class)
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        //set self-defined errorHandler
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
        return restTemplate;
    }

//    @Bean
//    @ConditionalOnMissingBean(ClientHttpRequestFactory.class)
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setConnectTimeout(CONNECT_TIMEOUT);
//        factory.setReadTimeout(READ_TIMEOUT);
//        return factory;
//    }
}
