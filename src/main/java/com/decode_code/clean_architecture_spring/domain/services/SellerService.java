package com.decode_code.clean_architecture_spring.domain.services;

import com.decode_code.clean_architecture_spring.domain.bo.SellerBO;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerStatusNotAllowedException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellersActiveNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.StorageException;

import java.util.List;

public interface SellerService {

    SellerBO createSeller(SellerBO sellerBO) throws StorageException;

    SellerBO findSellerById(long id) throws SellerNotFoundException, StorageException;

    List<SellerBO> findActiveSellers() throws SellersActiveNotFoundException, StorageException;

    void checkSellerAccess(long id) throws SellerNotFoundException, SellerStatusNotAllowedException, StorageException;

}
