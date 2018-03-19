package com.springcloud.microservice.cloudstreama.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Jerry Xie
 * @date 3/16/2018 16:32
 */
@Slf4j
@EnableBinding(value = {MsgChannel.class})
public class MsgHandler {

    @Autowired
    @Qualifier(MsgChannel.OUTPUT_CHANNEL_NAME)
    private MessageChannel out;

    public void send(final String info) {
        out.send(MessageBuilder.withPayload(info).build());
    }

    @StreamListener(MsgChannel.INPUT_CHANNEL_NAME)
    public void receive(@Payload String payload) {
        log.info("received: " + payload);
    }

}
