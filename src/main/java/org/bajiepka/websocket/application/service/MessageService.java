package org.bajiepka.websocket.application.service;

import org.bajiepka.websocket.application.domain.entity.ChatMessage;
import org.bajiepka.websocket.application.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AnnotationConfigApplicationContext ctx;

    public List<ChatMessage> getMessages() {
        return messageRepository.findAll();
    }

    public void saveMessage(Map<String, Object> map) {

        ChatMessage message = (ChatMessage) ctx.getBean("message");
        message.setMessage((String) map.get("message"));
        message.setAuthor((String) map.get("name"));
        messageRepository.save(message);
    }
}
