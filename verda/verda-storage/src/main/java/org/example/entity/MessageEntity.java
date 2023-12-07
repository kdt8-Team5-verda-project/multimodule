package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "message")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageId")
    private long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @CreatedDate
    @Column
    private LocalDateTime sendTime;

    @Column
    private String senderEmail;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private ChatRoomEntity chatRoomEntity;

    @PrePersist
    void prePersist() {
        this.sendTime = LocalDateTime.now();
    }

    public MessageEntity(String content, String senderEmail, ChatRoomEntity chatRoomEntity){
        this.chatRoomEntity=chatRoomEntity;
        this.content=content;
        this.senderEmail=senderEmail;
    }
}