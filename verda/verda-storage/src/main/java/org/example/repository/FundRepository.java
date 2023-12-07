package org.example.repository;

import java.util.Optional;
import org.example.entity.FundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundRepository extends JpaRepository<FundEntity, Long> {
    Optional<FundEntity> findByEmail(String email);

}