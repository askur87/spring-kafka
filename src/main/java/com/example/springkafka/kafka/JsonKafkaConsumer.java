package com.example.springkafka.kafka;

import com.example.springkafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "jsontopic", groupId = "myGroup")
    public void consume(User data) {
        LOGGER.info(String.format("Json Message received -> %s", data.toString()));
    }
}
