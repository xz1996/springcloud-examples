package com.springcloud.microservice.cloudstreamb.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Jerry Xie
 * @date 3/16/2018 17:58
 */
public interface MsgChannel {

    public static final String INPUT_CHANNEL_NAME = "selfInputChannel";
    public static final String OUTPUT_CHANNEL_NAME = "selfOutputChannel";

    @Input(INPUT_CHANNEL_NAME)
    SubscribableChannel input();

    @Output(OUTPUT_CHANNEL_NAME)
    MessageChannel output();
}
