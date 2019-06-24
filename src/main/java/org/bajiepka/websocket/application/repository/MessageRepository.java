package org.bajiepka.websocket.application.repository;

import org.bajiepka.websocket.application.domain.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<ChatMessage, Integer> {
}
