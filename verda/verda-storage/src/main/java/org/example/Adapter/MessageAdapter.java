package org.example.Adapter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.annotation.Adaptor;
import org.example.entity.MessageEntity;
import org.example.repository.MessageRepository;

@Adaptor
@RequiredArgsConstructor
public class MessageAdapter {
    private final MessageRepository messageRepository;

    public List<MessageEntity> findByChatRoomEntity_Id(long id){
        return messageRepository.findByChatRoomEntity_Id(id);
    }
}
