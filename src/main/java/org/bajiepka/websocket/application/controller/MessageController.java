package org.bajiepka.websocket.application.controller;

import org.bajiepka.websocket.application.domain.Greeting;
import org.bajiepka.websocket.application.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Map;

@Controller
public class MessageController {

    @Autowired
    private BasicJsonParser parser;

    @Autowired
    private MessageService service;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting messaging(String message) throws InterruptedException {

        Map<String, Object> map = parser.parseMap(message);
        if (map.containsKey("save") && Boolean.valueOf((String) map.get("save"))) saveToDatabase(map);
        return new Greeting(String.format("[%s] %s: %s", new Date(), map.get("name"), map.get("message")));
    }

    private void saveToDatabase(Map<String, Object> map) {
        Thread thread = new Thread() {
            public void run() {
                service.saveMessage(map);
            }
        };
        thread.start();
    }
}
