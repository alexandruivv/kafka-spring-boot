package com.example.kafkaexample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class KafkaConsumer {
    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class.getName());
    private CountDownLatch latch = new CountDownLatch(1);
    private String payload;

    @KafkaListener(topics = "${kafka.topic}", groupId = "foo")
    void listener(String data) {
        LOGGER.info("Received message: " + data + " :D");
        latch.countDown();
        payload = data;
    }

    public void resetLatch() {
        latch = new CountDownLatch(1);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public String getPayload() {
        return payload;
    }
}
