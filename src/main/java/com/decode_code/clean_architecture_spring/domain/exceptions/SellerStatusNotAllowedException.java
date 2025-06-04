package com.decode_code.clean_architecture_spring.domain.exceptions;

import com.decode_code.clean_architecture_spring.domain.enums.SellerStatus;

public class SellerStatusNotAllowedException extends DomainCheckedException {

    public SellerStatusNotAllowedException(final SellerStatus status, final long id) {
        super(String.format("Seller not allowed to access with status: %s and ID: %d", status, id));
    }

}

