package com.ecommerce.server.repository;

import com.ecommerce.server.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    Conversation findOneByUserId(Integer userId);
}
