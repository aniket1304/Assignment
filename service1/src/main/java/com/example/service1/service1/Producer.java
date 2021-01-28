package com.example.service1.service1;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final  String TOPIC = "test_topic1";

    public int flag = 1;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){

        if (flag==1) {

            this.kafkaTemplate.send(TOPIC, message);

        }

    }
}
