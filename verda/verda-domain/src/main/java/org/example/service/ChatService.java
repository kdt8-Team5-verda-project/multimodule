package org.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.Adapter.ChatAdapter;
import org.example.Adapter.MessageAdapter;
import org.example.common.ApiException;
import org.example.common.ErrorCode;
import org.example.dto.response.ChatRoomExistDTO;
import org.example.dto.response.ChatRoomInfoDTO;
import org.example.dto.response.GetTargetNameDTO;
import org.example.dto.response.PreChatListDTO;
import org.example.entity.ChatRoomEntity;
import org.example.entity.MessageEntity;
import org.example.repository.ChatRoomRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatAdapter chatAdapter;
    private final MessageAdapter messageAdapter;
    public GetTargetNameDTO getUserChatName(long roomId) {
        ChatRoomEntity chatRoom = chatAdapter.findById(roomId);
        GetTargetNameDTO getTargetNameDTO=new GetTargetNameDTO(chatRoom.getFundEntity().getName());
        return getTargetNameDTO;
    }

    /**
     * 현재 펀드매니저가 해당게시글에서 채팅방을 만들었는지 체크
     * @param fmId
     * @param postId
     */
    public ChatRoomExistDTO checkExistChat(long fmId, long postId) {
        Optional<ChatRoomEntity> chatroom = chatAdapter.findByFundEntityFmIdAndUserPostEntityPostId(
                fmId, postId);
        if(chatroom.isEmpty()){
            ChatRoomExistDTO chatRoomExistDTO = new ChatRoomExistDTO(-1);
            return chatRoomExistDTO;

        }else {
            ChatRoomExistDTO chatRoomExistDTO = new ChatRoomExistDTO(chatroom.get().getId());
            return chatRoomExistDTO;
        }
    }

    /* 채팅방 입장 후 */

    /**
     * 채팅방 예전 채팅기록 가져오기
     * @param roomId
     * @return
     */
    @Cacheable(cacheNames = "Message", key = "#roomId", condition = "#roomId != null")
    public List<PreChatListDTO> getPreMessage(long roomId) {
        List<MessageEntity> messageList = messageAdapter.findByChatRoomEntity_Id(roomId);
        List<PreChatListDTO> messageDto=new ArrayList<PreChatListDTO>();
        for(MessageEntity message:messageList){
            PreChatListDTO preChat=new PreChatListDTO(message);
            messageDto.add(preChat);
        }
//        GetPreChatListDTO getPreChatListDto = new GetPreChatListDTO(messageList);
        return messageDto;
    }


    public ChatRoomInfoDTO createChatRoom(long postId, long userId, Long fmId) {
//        UserPostEntity getPost = boardRepository.findById(createChatRoom.getPostId())
//                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND_BOARD));
//        UserEntity getUser = kakaoRepository.findById(createChatRoom.getUserId())
//                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND_MEMBER));
//        FundEntity getFund = fundRepository.findById(fmId)
//                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND_FUND));
//        ChatRoomEntity chatRoomEntity = new ChatRoomEntity(getPost, getUser, getFund);
//        chatRoomRepository.save(chatRoomEntity);
//        MessageEntity enterMessage=new MessageEntity(chatRoomEntity.getUserPostEntity().getContent(),chatRoomEntity.getUserEntity().getEmail(),chatRoomEntity);
//        messageRepository.save(enterMessage);
////        putEmptyArrayInCache("Message", String.valueOf(chatRoomEntity.getId()));
//
//        ChatRoomInfoDTO chatRoomInfoDTO=new ChatRoomInfoDTO(chatRoomEntity.getId());
        return null;
    }
}
