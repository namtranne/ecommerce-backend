package com.ecommerce.server.service;

import com.ecommerce.server.entity.Conversation;
import com.ecommerce.server.entity.Message;
import com.ecommerce.server.repository.ConversationRepository;
import com.ecommerce.server.repository.MessageRepository;
import com.ecommerce.server.security.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ChatService {

    private SimpMessageSendingOperations simpMessageSendingOperations;

    private ConversationRepository conversationRepository;
//
    private MessageRepository messageRepository;

    @Autowired
    public ChatService(
            SimpMessageSendingOperations simpMessageSendingOperations,
            ConversationRepository conversationRepository, MessageRepository messageRepository)
//            OnlineOfflineService onlineOfflineService) {
    {
        this.simpMessageSendingOperations = simpMessageSendingOperations;
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
//        this.onlineOfflineService = onlineOfflineService;
    }

    public void   sendMessageToConvId(
            String chatMessage, String conversationId, SimpMessageHeaderAccessor headerAccessor) {
        CustomUserDetails userDetails = getUser();
        Integer userId = userDetails.getUser().getId();
//        conversationRepository.save(conversationEntityBuilder.build());
        simpMessageSendingOperations.convertAndSend("/topic/" + 123, chatMessage);
    }

    public CustomUserDetails getUser() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (CustomUserDetails)object;
    }

    public void sendMessageToAdmin(String chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        CustomUserDetails userDetails = getUser();
        Integer userId = userDetails.getUser().getId();
        simpMessageSendingOperations.convertAndSend("/topic/admin" , "Message from " + userId + " " + chatMessage);

    }

    public List<Conversation> getAllConversation() {
        return conversationRepository.findAll();
    }

    public Conversation findConversation(Integer userId) {
        return conversationRepository.findOneByUserId(userId);
    }

    public Conversation createConversation(Integer userId) {
        Conversation conversation = new Conversation();
        conversation.setUserId(userId);
        conversation.setCreatedAt(Date.valueOf(LocalDate.now()));
        conversation.setUpdatedAt(Date.valueOf(LocalDate.now()));
        return conversationRepository.save(conversation);
    }

    public void saveMessage(String chatMessage) {
        Message message = new Message();
        message.setMessageText(chatMessage);
        message.setSentAt(Date.valueOf(LocalDate.now()));
        message.setIsRead(false);
        Integer userId = getUser().getUser().getId();
        Conversation conversation = findConversation(userId);
        if(conversation == null) {
            conversation = createConversation(userId);
        }
        message.setConversationId(conversation.getId());
        message = messageRepository.save(message);
        conversation.setLastMessage(message);
        conversationRepository.save(conversation);
    }
}