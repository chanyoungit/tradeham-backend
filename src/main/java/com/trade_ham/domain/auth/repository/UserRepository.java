package com.trade_ham.domain.auth.repository;

import com.trade_ham.domain.auth.entity.UserEntity;
import com.trade_ham.global.common.enums.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Transactional(readOnly = true)
    UserEntity findByProviderAndEmail(Provider provider, String email);
}
