package com.decode_code.clean_architecture_spring.application.handlers.impl;

import com.decode_code.clean_architecture_spring.application.dto.requests.SellerRequest;
import com.decode_code.clean_architecture_spring.application.dto.responses.SellerResponse;
import com.decode_code.clean_architecture_spring.application.handlers.SellerHandler;
import com.decode_code.clean_architecture_spring.application.mappers.MapperUtil;
import com.decode_code.clean_architecture_spring.domain.bo.SellerBO;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerStatusNotAllowedException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellersActiveNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.StorageException;
import com.decode_code.clean_architecture_spring.domain.services.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class SellerHandlerImpl implements SellerHandler {

    private final SellerService sellerService;

    public SellerHandlerImpl(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public ResponseEntity<SellerResponse> createSeller(SellerRequest sellerRequest)
            throws StorageException {

        SellerResponse sellerResponse = MapperUtil.convert(
                sellerService.createSeller(MapperUtil.convert(sellerRequest, SellerBO.class)),
                SellerResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(sellerResponse);

    }

    @Override
    public ResponseEntity<SellerResponse> findSellerById(long id)
            throws StorageException, SellerNotFoundException {

        SellerBO sellerBO = sellerService.findSellerById(id);
        SellerResponse sellerResponse = MapperUtil.convert(sellerBO, SellerResponse.class);
        return ResponseEntity.ok(sellerResponse);
    }

    @Override
    public ResponseEntity<List<SellerResponse>> findActiveSellers()
            throws SellersActiveNotFoundException, StorageException {

        List<SellerBO> activeSellers = sellerService.findActiveSellers();
        List<SellerResponse> sellerResponses = MapperUtil.convertList(activeSellers, SellerResponse.class);
        return ResponseEntity.ok(sellerResponses);
    }

    @Override
    public ResponseEntity<Void> checkSellerAccess(long id)
            throws SellerStatusNotAllowedException, StorageException, SellerNotFoundException {

        sellerService.checkSellerAccess(id);
        return ResponseEntity.ok().build();
    }

}
