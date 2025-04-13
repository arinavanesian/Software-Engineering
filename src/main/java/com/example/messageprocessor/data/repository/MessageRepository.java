package com.example.messageprocessor.data.repository;

import com.example.messageprocessor.data.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
