package com.decode_code.clean_architecture_spring.application.handlers;

import com.decode_code.clean_architecture_spring.application.dto.requests.SellerRequest;
import com.decode_code.clean_architecture_spring.application.dto.responses.SellerResponse;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerStatusNotAllowedException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellersActiveNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.StorageException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SellerHandler {

    ResponseEntity<SellerResponse> createSeller(SellerRequest sellerRequest) throws StorageException;

    ResponseEntity<SellerResponse> findSellerById(long id) throws StorageException, SellerNotFoundException;

    ResponseEntity<List<SellerResponse>> findActiveSellers() throws SellersActiveNotFoundException, StorageException;

    ResponseEntity<Void> checkSellerAccess(long id) throws SellerStatusNotAllowedException, StorageException, SellerNotFoundException;

}
