package com.example.messageprocessor.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Test
    void shouldProcessValidMessage() {
        messageService.processMessage("test message");
    }
}
