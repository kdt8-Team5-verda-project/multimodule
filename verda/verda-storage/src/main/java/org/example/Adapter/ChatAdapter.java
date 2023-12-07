package org.example.Adapter;


import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.annotation.Adaptor;
import org.example.common.ApiException;
import org.example.common.ErrorCode;
import org.example.entity.ChatRoomEntity;
import org.example.repository.ChatRoomRepository;

@Adaptor
@RequiredArgsConstructor
public class ChatAdapter {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomEntity findById(Long id){return chatRoomRepository.findById(id).orElseThrow(()->new ApiException(
            ErrorCode.NOT_FOUND_CHAT));}

    public Optional<ChatRoomEntity> findByFundEntityFmIdAndUserPostEntityPostId(Long fmId, Long postId){
        return chatRoomRepository.findByFundEntityFmIdAndUserPostEntityPostId(fmId,postId);
    }
}
