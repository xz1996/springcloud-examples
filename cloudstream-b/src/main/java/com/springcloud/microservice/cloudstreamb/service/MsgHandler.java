package com.springcloud.microservice.cloudstreamb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author Jerry Xie
 * @date 3/12/2018 23:46
 */
@Slf4j
@EnableBinding(value = {MsgChannel.class})
public class MsgHandler {

    @StreamListener(MsgChannel.INPUT_CHANNEL_NAME)
    @SendTo(MsgChannel.OUTPUT_CHANNEL_NAME)
    public String receive(@Payload String payload) {
        log.info("received: " + payload);
        return "this is b";
    }
}
