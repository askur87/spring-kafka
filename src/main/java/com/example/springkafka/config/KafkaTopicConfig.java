package com.example.springkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public NewTopic testTopic() {
        return TopicBuilder.name("testtopic")
                .build();
    }

    public NewTopic jsonTopic() {
        return TopicBuilder.name("jsontopic")
                .build();
    }
}
