package com.example.service1.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Producer producer;

    @Autowired
    public TestController(Producer producer){
        this.producer = producer;
    }

    @PostMapping("/start1")
    public void messageToTopic(){
        this.producer.flag=1;
        this.producer.sendMessage("This Message is from Service 1");
    }

    @PostMapping("/stop1")
    public void stopmessage(){
        this.producer.flag=0;
    }

}
