package org.bajiepka.websocket.application;

import lombok.extern.slf4j.Slf4j;
import org.bajiepka.websocket.application.service.MessageService;
import org.bajiepka.websocket.application.web.dto.MessageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MessageService service;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Приложение запущено!");
        List<MessageDto> messages = service.getMessages()
                .stream()
                .map(message -> {
                    return mapper.map(message, MessageDto.class);
                })
                .collect(Collectors.toList());

        System.out.println(messages);

    }
}
