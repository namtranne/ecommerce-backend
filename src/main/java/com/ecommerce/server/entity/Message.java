package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "conversation_id", nullable = false)
    private Integer conversationId;

    @Column(name = "sender_id", nullable = false)
    private Integer senderId;

    @Column(name = "message_text", nullable = false, columnDefinition = "TEXT")
    private String messageText;

    @Column(name = "sent_at", nullable = false)
    private Date sentAt;

    @Column(name = "is_read", nullable = false)
    private Boolean isRead;

    public Message() {
        // Default constructor for JPA
    }
}
