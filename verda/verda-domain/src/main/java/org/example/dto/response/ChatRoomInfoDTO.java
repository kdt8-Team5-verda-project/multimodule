package org.example.dto.response;

import lombok.Getter;

@Getter
public class ChatRoomInfoDTO {
    private long roomId;

    public ChatRoomInfoDTO(long roomId){
        this.roomId=roomId;
    }
}
