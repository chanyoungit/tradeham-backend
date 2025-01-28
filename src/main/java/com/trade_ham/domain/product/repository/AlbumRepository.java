package com.trade_ham.domain.product.repository;

import com.trade_ham.domain.product.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {}