package org.example.dto.response;

import lombok.Getter;
import org.example.entity.MessageEntity;

@Getter
public class PreChatListDTO {
    private String content;
    private String sender_email;

    public PreChatListDTO(MessageEntity message){
        this.content= message.getContent();
        this.sender_email= message.getSenderEmail();
    }
}