package com.decode_code.clean_architecture_spring.domain.services.impl;

import com.decode_code.clean_architecture_spring.domain.bo.SellerBO;
import com.decode_code.clean_architecture_spring.domain.enums.SellerStatus;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerStatusNotAllowedException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellersActiveNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.StorageException;
import com.decode_code.clean_architecture_spring.domain.repositories.SellerRepository;
import com.decode_code.clean_architecture_spring.domain.services.SellerService;

import java.util.List;
import java.util.Optional;

public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SellerBO createSeller(SellerBO sellerBO) throws StorageException {
        return sellerRepository.createSeller(sellerBO);
    }

    @Override
    public SellerBO findSellerById(long id) throws SellerNotFoundException, StorageException {
        Optional<SellerBO> optionalSellerBO = sellerRepository.findSellerById(id);

        if (optionalSellerBO.isEmpty()) {
            throw new SellerNotFoundException(id);
        }

        return optionalSellerBO.get();
    }

    @Override
    public List<SellerBO> findActiveSellers() throws SellersActiveNotFoundException, StorageException {
        List<SellerBO> sellerBOS = sellerRepository.findActiveSellers();

        if (sellerBOS.isEmpty()){
            throw new SellersActiveNotFoundException();
        }

        return sellerBOS;
    }

    @Override
    public void checkSellerAccess(long id) throws SellerNotFoundException, SellerStatusNotAllowedException, StorageException {
        Optional<SellerBO> optionalSellerBO = sellerRepository.findSellerById(id);

        if (optionalSellerBO.isEmpty()) {
            throw new SellerNotFoundException(id);
        }

        SellerBO sellerBO = optionalSellerBO.get();

        if (!SellerStatus.ACTIVE.equals(sellerBO.getStatus())){
            throw new SellerStatusNotAllowedException(sellerBO.getStatus(), id);
        }

    }
}
