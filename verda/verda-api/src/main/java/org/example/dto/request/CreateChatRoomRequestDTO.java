package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateChatRoomRequestDTO {
    private long postId;
    private long userId;
}
