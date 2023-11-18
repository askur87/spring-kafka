package com.example.springkafka.controller;

import com.example.springkafka.kafka.JsonKafkaProducer;
import com.example.springkafka.kafka.KafkaProducer;
import com.example.springkafka.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;
    private JsonKafkaProducer jsonKafkaProducer;

    public MessageController(KafkaProducer kafkaProducer, JsonKafkaProducer jsonKafkaProducer) {
        this.kafkaProducer = kafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @PostMapping("/publish-json")
    public ResponseEntity<String> publishJson(@RequestBody User message) {
        jsonKafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Json Message sent to the topic");
    }
}
