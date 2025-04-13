package com.example.messageprocessor.service;

import com.example.messageprocessor.data.entity.Message;
import com.example.messageprocessor.data.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class MessageService {
    
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional
    public void processMessage(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Message content cannot be empty");
        }

        Message message = new Message();
        message.setContent(content);
        message.setProcessedAt(Instant.now());
        
        messageRepository.save(message);
    }
}