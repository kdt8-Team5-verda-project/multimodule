package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "chatRoom")
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private long id;

    @ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    UserPostEntity userPostEntity;

    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "userId")
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "fmId", referencedColumnName = "fmId")
    FundEntity fundEntity;

    @OneToMany(mappedBy = "chatRoomEntity")
    private List<MessageEntity> messages = new ArrayList<>();

    public ChatRoomEntity(UserPostEntity userPostEntity, UserEntity userEntity, FundEntity fundEntity){
        this.userEntity=userEntity;
        this.fundEntity=fundEntity;
        this.userPostEntity=userPostEntity;
    }
}
