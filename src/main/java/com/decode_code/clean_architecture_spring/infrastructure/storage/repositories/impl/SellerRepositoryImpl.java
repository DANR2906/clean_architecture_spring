package com.decode_code.clean_architecture_spring.infrastructure.storage.repositories.impl;

import com.decode_code.clean_architecture_spring.application.mappers.MapperUtil;
import com.decode_code.clean_architecture_spring.domain.bo.SellerBO;
import com.decode_code.clean_architecture_spring.domain.enums.SellerStatus;
import com.decode_code.clean_architecture_spring.domain.exceptions.StorageException;
import com.decode_code.clean_architecture_spring.domain.repositories.SellerRepository;
import com.decode_code.clean_architecture_spring.infrastructure.storage.entities.SellerEntity;
import com.decode_code.clean_architecture_spring.infrastructure.storage.repositories.SellerJpaRepository;
import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SellerRepositoryImpl implements SellerRepository {

    private final SellerJpaRepository sellerJpaRepository;

    public SellerRepositoryImpl(SellerJpaRepository sellerJpaRepository) {
        this.sellerJpaRepository = sellerJpaRepository;
    }

    @Override
    public SellerBO createSeller(SellerBO sellerBO) throws StorageException {
        try {
            return MapperUtil.convert(
                    sellerJpaRepository.save(
                            MapperUtil.convert(sellerBO, SellerEntity.class)),
                    SellerBO.class);
        } catch (PersistenceException e) {
            throw new StorageException(e.getMessage(), e);
        }

    }

    @Override
    public Optional<SellerBO> findSellerById(Long id) throws StorageException {
        try {
            return sellerJpaRepository.findById(id)
                    .map(sellerEntity -> MapperUtil.convert(sellerEntity, SellerBO.class));
        } catch (PersistenceException e) {
            throw new StorageException(e.getMessage(), e);
        }

    }

    @Override
    public List<SellerBO> findActiveSellers() throws StorageException {
        try {
            return MapperUtil.convertList(
                    sellerJpaRepository.findAllByStatus(SellerStatus.ACTIVE),
                    SellerBO.class);
        } catch (PersistenceException e) {
            throw new StorageException(e.getMessage(), e);
        }
    }

}
