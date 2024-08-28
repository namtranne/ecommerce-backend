package com.ecommerce.server.controller;

import com.ecommerce.server.constant.HttpStatusCode;
import com.ecommerce.server.dto.AdminChatResponse;
import com.ecommerce.server.entity.Conversation;
import com.ecommerce.server.entity.Message;
import com.ecommerce.server.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@Slf4j
public class ChatController {

    @Autowired
    private ChatService chatService;

//    @Autowired
//    public ChatController(ChatService chatService) {
//        this.chatService = chatService;
//    }

//    @MessageMapping("/chat/sendMessage/{convId}")
//    public ChatMessage sendMessageToConvId(
//            @Payload ChatMessage chatMessage,
//            SimpMessageHeaderAccessor headerAccessor,
//            @DestinationVariable("convId") String conversationId) {
//        chatService.sendMessageToConvId(chatMessage, conversationId, headerAccessor);
//        return chatMessage;
//    }

//    @MessageMapping("/chat/sendMessage/{convId}")
//    public void sendMessageToConvId(
//            SimpMessageHeaderAccessor headerAccessor,
//            @DestinationVariable("convId") String conversationId) {
//        chatService.sendMessageToConvId("Hello", conversationId, headerAccessor);
//    }

    @MessageMapping("/chat/sendMessage/admin")
    public void sendMessageToAdmin(@Payload String chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        chatService.saveMessage(chatMessage);
        chatService.sendMessageToAdmin(chatMessage, headerAccessor);
    }

    @GetMapping("/api/admin/chat")
    public ResponseEntity<AdminChatResponse> getAllChat() {
        try {
            List<Conversation> conversations = chatService.getAllConversation();
            AdminChatResponse response = new AdminChatResponse(conversations, HttpStatusCode.OK);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}