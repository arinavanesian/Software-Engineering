package com.example.messageprocessor.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 3, topics = {"messages"})
class KafkaConsumerTest {
    
    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Test
    void contextLoads() {
        assertNotNull(kafkaConsumer, "KafkaConsumer should be initialized");
    }
}