package com.example.messageprocessor.api;

import com.example.messageprocessor.service.MessageService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;

@Component
public class KafkaConsumer {
    
    private final MessageService messageService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    public KafkaConsumer(MessageService messageService, KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    public KafkaConsumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @KafkaListener(topics = "${app.kafka.topic}")
    public void consume(String message) {
        try {
            messageService.processMessage(message);
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
            // I will handle the dead letters here by sending them to the dead-letter topic
            System.err.println("Sending message to dead-letter queue: " + message);
            kafkaTemplate.send("${app.kafka.dead-letter-topic}", message);

        }
    }
}