package com.decode_code.clean_architecture_spring.domain.exceptions;

public class SellersActiveNotFoundException extends DomainCheckedException {

    public SellersActiveNotFoundException() {
        super("Not found active sellers in the platform");
    }

}

