package org.bajiepka.websocket.application.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageDto {

    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
    private Date deletedAt;
    private Integer accountId;
    private String message;

}
