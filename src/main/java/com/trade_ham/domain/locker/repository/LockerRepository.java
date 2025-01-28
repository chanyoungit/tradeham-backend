package com.trade_ham.domain.locker.repository;

import com.trade_ham.domain.locker.entity.LockerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface LockerRepository extends JpaRepository<LockerEntity, Long> {
    @Transactional(readOnly = true)
    Optional<LockerEntity> findFirstByLockerStatusTrue();
}