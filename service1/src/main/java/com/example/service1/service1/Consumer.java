package com.example.service1.service1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;
@Service
public class Consumer {

    private final Producer producer;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Consumer(Producer producer) {
        this.producer = producer;

    }

    @KafkaListener(topics = "test_topic2", groupId = "group_id")
    public void consumeMessage(String message) throws InterruptedException {
        System.out.println((message));

        String psql = "INSERT INTO msg (msgg) VALUES (?)";

        jdbcTemplate.update(psql,message);

        TimeUnit.SECONDS.sleep(5);
        this.producer.sendMessage("This Message is from Service 1");




    }

}