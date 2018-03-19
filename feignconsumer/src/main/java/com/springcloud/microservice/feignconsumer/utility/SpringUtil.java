package com.springcloud.microservice.feignconsumer.utility;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Jerry Xie
 * @date 7/20/2017 10:25
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    public static Object getBean(final String name){
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType){
        return getApplicationContext().getBean(requiredType);
    }

    public static <T> T getBean(final String name, Class<T> requiredType){
        return getApplicationContext().getBean(name, requiredType);
    }

}
