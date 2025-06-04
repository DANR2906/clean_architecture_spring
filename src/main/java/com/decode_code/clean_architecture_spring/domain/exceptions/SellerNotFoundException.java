package com.decode_code.clean_architecture_spring.domain.exceptions;

public class SellerNotFoundException extends DomainCheckedException {

    public SellerNotFoundException(final long id) {
        super("Seller not found with ID: " + id);
    }

}

