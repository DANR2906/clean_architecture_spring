package com.decode_code.clean_architecture_spring.presentation.controllers.impl;

import com.decode_code.clean_architecture_spring.application.dto.requests.SellerRequest;
import com.decode_code.clean_architecture_spring.application.dto.responses.SellerResponse;
import com.decode_code.clean_architecture_spring.application.handlers.SellerHandler;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellerStatusNotAllowedException;
import com.decode_code.clean_architecture_spring.domain.exceptions.SellersActiveNotFoundException;
import com.decode_code.clean_architecture_spring.domain.exceptions.StorageException;
import com.decode_code.clean_architecture_spring.presentation.controllers.SellerController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerControllerImpl implements SellerController {

    private final SellerHandler sellerHandler;

    public SellerControllerImpl(SellerHandler sellerHandler) {
        this.sellerHandler = sellerHandler;
    }

    @Override
    @PostMapping
    public ResponseEntity<SellerResponse> createSeller(@Valid @RequestBody SellerRequest sellerRequest) throws StorageException {

        return sellerHandler.createSeller(sellerRequest);

    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SellerResponse> findSellerById(@PathVariable long id) throws StorageException {
        try {
            return sellerHandler.findSellerById(id);
        } catch (SellerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @Override
    @GetMapping("/active")
    public ResponseEntity<List<SellerResponse>> findActiveSellers() throws StorageException {
        try {
            return sellerHandler.findActiveSellers();
        } catch (SellersActiveNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @Override
    @GetMapping("/{id}/check-access")
    public ResponseEntity<Void> checkSellerAccess(@PathVariable long id) throws StorageException {
        try {
            return sellerHandler.checkSellerAccess(id);
        } catch (SellerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (SellerStatusNotAllowedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
