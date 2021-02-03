package com.kafkaconsumer.example.listeners;

import com.kafkaconsumer.example.dto.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka-example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "kafka-json-example", groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed Json message: " + user.toString());
    }
}
