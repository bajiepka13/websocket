package org.bajiepka.websocket.application.configuration;

import org.bajiepka.websocket.application.domain.entity.ChatMessage;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "message")
    @Scope("prototype")
    public ChatMessage chatMessage() {
        return new ChatMessage();
    }

}
