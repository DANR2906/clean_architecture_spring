package com.decode_code.clean_architecture_spring.presentation.controllers;

import com.decode_code.clean_architecture_spring.application.dto.requests.SellerRequest;
import com.decode_code.clean_architecture_spring.application.dto.responses.SellerResponse;
import com.decode_code.clean_architecture_spring.domain.exceptions.StorageException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SellerController {

    ResponseEntity<SellerResponse> createSeller(@Valid @RequestBody SellerRequest sellerRequest) throws StorageException;

    ResponseEntity<SellerResponse> findSellerById(@PathVariable long id) throws StorageException;

    ResponseEntity<List<SellerResponse>> findActiveSellers() throws StorageException;

    ResponseEntity<Void> checkSellerAccess(@PathVariable long id) throws StorageException;

}
