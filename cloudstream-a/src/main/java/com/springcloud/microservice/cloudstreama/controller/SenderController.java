package com.springcloud.microservice.cloudstreama.controller;

import com.springcloud.microservice.cloudstreama.service.MsgHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Jerry Xie
 * @date 3/16/2018 17:20
 */
@Controller("SenderController")
public class SenderController {

    @Autowired
    private MsgHandler msgHandler;


    @PostMapping("/send")
    public ResponseEntity send(@RequestBody final String body) {
        msgHandler.send(body);
        return new ResponseEntity(body, HttpStatus.OK);
    }
}
