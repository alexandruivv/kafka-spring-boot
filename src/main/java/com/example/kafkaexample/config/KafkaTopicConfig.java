package com.example.kafkaexample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Bean
    public NewTopic exampleTopic() {
        return TopicBuilder.name(kafkaTopic)
                .build();
    }
}
