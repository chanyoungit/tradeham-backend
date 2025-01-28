package com.trade_ham.domain.product.repository;

import com.trade_ham.domain.auth.entity.UserEntity;
import com.trade_ham.domain.product.entity.ProductEntity;
import com.trade_ham.domain.product.entity.ProductStatus;
import io.lettuce.core.dynamic.annotation.Param;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Transactional(readOnly = true)
    Optional<ProductEntity> findByProductId(Long productId);

    @Transactional(readOnly = true)
    List<ProductEntity> findByNameContainingIgnoreCase(String name);

    @Transactional(readOnly = true)
    List<ProductEntity> findBySeller(UserEntity seller);

    @Transactional(readOnly = true)
    List<ProductEntity> findByBuyer(UserEntity buyer);

    @Transactional(readOnly = true)
    List<ProductEntity> findByStatusOrderByCreatedAtDesc(ProductStatus status);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM ProductEntity p WHERE p.productId = :productId")
    @Transactional(readOnly = true)
    Optional<ProductEntity> findByIdWithPessimisticLock(@Param("productId") Long productId);

    @Transactional(readOnly = true)
    @Query("SELECT p FROM ProductEntity p " +
            "WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND p.status = 'SELL' " +
            "ORDER BY p.createdAt DESC")
    List<ProductEntity> searchProducts(@Param("keyword") String keyword);

}

