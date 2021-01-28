package com.example.service2.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Producer producer;

    @Autowired
    public TestController(Producer producer){
        this.producer = producer;
    }

    @PostMapping("/start2")
    public void messageToTopic(){
        this.producer.flag=1;
        this.producer.sendMessage("This Message is from Service 2");
    }

    @PostMapping("/stop2")
    public void stopmessage(){
        this.producer.flag=0;
    }
}
