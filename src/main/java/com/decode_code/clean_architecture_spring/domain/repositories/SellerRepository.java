package com.decode_code.clean_architecture_spring.domain.repositories;

import com.decode_code.clean_architecture_spring.domain.bo.SellerBO;
import com.decode_code.clean_architecture_spring.domain.exceptions.StorageException;

import java.util.List;
import java.util.Optional;

public interface SellerRepository {

    SellerBO createSeller(SellerBO sellerBO) throws StorageException;

    Optional<SellerBO> findSellerById(Long id) throws StorageException;

    List<SellerBO> findActiveSellers() throws StorageException;

}
