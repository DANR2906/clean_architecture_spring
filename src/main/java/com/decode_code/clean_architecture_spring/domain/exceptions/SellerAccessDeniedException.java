package com.decode_code.clean_architecture_spring.domain.exceptions;

public class SellerAccessDeniedException extends DomainCheckedException {

    public SellerAccessDeniedException(final String message) {
        super(message);
    }

}

