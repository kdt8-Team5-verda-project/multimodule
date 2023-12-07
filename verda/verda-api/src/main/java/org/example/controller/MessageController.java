package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.GetTargetNameDTO;
import org.example.dto.response.PreChatListDTO;
import org.example.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final ChatService chatService;
    /**
     * 유저용 채팅방 이름 가져오기
     * @param roomId
     */
    @Operation(summary = "채팅방 이름 가져오기", description = "")
    @GetMapping("/api/chat/user/{roomId}")
    public GetTargetNameDTO getUserChatName(@PathVariable("roomId") long roomId){
        GetTargetNameDTO targetName = chatService.getUserChatName(roomId);
        return targetName;
    }

    /**
     * 채팅방 입장시 이전 채팅목록 조회
     * @param roomId
     * @return
     */
    @Operation(summary = "채팅방 입장시 이전 채팅목록 조회", description = "채팅방 입장시 이전 채팅들을 불러옴")
    @GetMapping("/api/chat/{roomId}")
    public List<PreChatListDTO> getPreMessage(@PathVariable("roomId") long roomId) {
        return chatService.getPreMessage(roomId);
    }



}
