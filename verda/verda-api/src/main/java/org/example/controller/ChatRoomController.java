package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.common.JwtDecode;
import org.example.dto.request.CreateChatRoomRequestDTO;
import org.example.dto.response.ChatRoomExistDTO;
import org.example.dto.response.ChatRoomInfoDTO;
import org.example.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChatRoomController {
    private final ChatService chatService;
    private final JwtDecode jwtDecode;

    @Operation(summary = "현재 게시글관련 채팅방유무 체크",description = "펀드매니저가 현재접속한 게시글에서 만든 채팅방이 있는지 확인하는 api")
    @GetMapping("/exist/chat/{postId}")
    public ChatRoomExistDTO checkChatExist(@RequestHeader("Authorization") String authorizationHeader, @PathVariable(name = "postId") long postId){
        long fmId = jwtDecode.executeDecode(authorizationHeader).get("fmId", Long.class);
        ChatRoomExistDTO checkExist = chatService.checkExistChat(fmId, postId);
        return checkExist;
    }

    /**
     * 채팅하기 클릭시 채팅방생성함수 실행 채팅방 생성
     */
//    @Operation(summary = "채팅방생성", description = "제안서작성 버튼 클릭시 실행")
//    @PostMapping("/chat")
//    public ChatRoomInfoDTO createChatRoom(@RequestBody CreateChatRoomRequestDTO createChatRoom,@RequestHeader("Authorization") String authorizationHeader) {
//        Long fmId = jwtDecode.executeDecode(authorizationHeader).get("fmId", Long.class);
//        ChatRoomInfoDTO chatRoomId = chatService.createChatRoom(createChatRoom, fmId);
//        return chatRoomId;
//    }
    @Operation(summary = "채팅방생성", description = "제안서작성 버튼 클릭시 실행")
    @PostMapping("/chat")
    public ChatRoomInfoDTO createChatRoom(@RequestBody CreateChatRoomRequestDTO createChatRoom, @RequestHeader("Authorization") String authorizationHeader) {
        Long fmId = jwtDecode.executeDecode(authorizationHeader).get("fmId", Long.class);
        ChatRoomInfoDTO chatRoomId = chatService.createChatRoom(createChatRoom.getPostId(),createChatRoom.getUserId(), fmId);
        return chatRoomId;
    }


}
