package com.decode_code.clean_architecture_spring.infrastructure.storage.repositories;

import com.decode_code.clean_architecture_spring.domain.enums.SellerStatus;
import com.decode_code.clean_architecture_spring.infrastructure.storage.entities.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerJpaRepository extends JpaRepository<SellerEntity, Long> {

    List<SellerEntity> findAllByStatus(SellerStatus status);

}
