package com.example.messageprocessor.data;

import com.example.messageprocessor.data.entity.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.Instant;
import com.example.messageprocessor.data.repository.MessageRepository;

@DataJpaTest
class MessageRepositoryTest {
    @Autowired
    private MessageRepository repository;

    @Test
    void shouldSaveMessage() {
        Message message = new Message();
        message.setContent("test");
        message.setProcessedAt(Instant.now());
        repository.save(message);
    }
}
