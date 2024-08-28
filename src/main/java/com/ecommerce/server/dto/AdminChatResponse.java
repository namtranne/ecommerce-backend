package com.ecommerce.server.dto;

import com.ecommerce.server.entity.Conversation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AdminChatResponse {
    private List<Conversation> conversations;
    private Integer code;
}
