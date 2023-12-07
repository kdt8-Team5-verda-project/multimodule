package org.example.repository;

import java.util.Optional;
import org.example.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
    Optional<Object> findById(long roomId);

    Optional<ChatRoomEntity> findByFundEntityFmIdAndUserPostEntityPostId(Long fmId, Long postId);
}
