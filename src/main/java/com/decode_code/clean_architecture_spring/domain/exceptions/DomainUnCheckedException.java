package com.decode_code.clean_architecture_spring.domain.exceptions;

public class DomainUnCheckedException extends RuntimeException {

    public DomainUnCheckedException(String message) {
        super(message);
    }

    public DomainUnCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

}

