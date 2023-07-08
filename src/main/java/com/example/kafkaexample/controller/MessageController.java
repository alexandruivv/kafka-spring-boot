package com.example.kafkaexample.controller;

import com.example.kafkaexample.controller.requests.MessageRequest;
import com.example.kafkaexample.service.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        kafkaProducer.produceMessage(request.message());
    }
}
