package org.example.repository;

import java.util.Optional;
import org.example.entity.FundPicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundPicRepository extends JpaRepository<FundPicEntity, Long> {
    Optional<FundPicEntity> findByFundEntityFmId(Long fmId);
}
