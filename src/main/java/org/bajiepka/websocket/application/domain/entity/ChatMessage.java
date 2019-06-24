package org.bajiepka.websocket.application.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bajiepka.websocket.application.domain.AbstractChatMessage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Entity
@Table(schema = "websocket", name = "messages")
public class ChatMessage extends AbstractChatMessage {

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "message")
    private String message;

}
