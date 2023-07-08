package com.example.kafkaexample.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Value("${kafka.topic}")
    private String topic;

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceMessage(String message) {
        kafkaTemplate.send(topic, message);
    }

    public void produceMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

}
