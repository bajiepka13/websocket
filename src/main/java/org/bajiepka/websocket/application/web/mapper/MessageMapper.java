package org.bajiepka.websocket.application.web.mapper;

import org.bajiepka.websocket.application.domain.entity.ChatMessage;
import org.bajiepka.websocket.application.web.dto.MessageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ChatMessage toEntity(MessageDto dto) {
        return modelMapper.map(dto, ChatMessage.class);
    }

    public MessageDto toDto(ChatMessage message) {
        return modelMapper.map(message, MessageDto.class);
    }
}
