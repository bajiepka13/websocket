package org.bajiepka.websocket.application.service;

import org.bajiepka.websocket.application.domain.entity.ChatMessage;
import org.bajiepka.websocket.application.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<ChatMessage> getMessages() {
        return messageRepository.findAll();
    }

}
