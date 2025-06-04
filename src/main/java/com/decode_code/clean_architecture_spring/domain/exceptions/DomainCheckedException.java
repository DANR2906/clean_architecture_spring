package com.decode_code.clean_architecture_spring.domain.exceptions;

public class DomainCheckedException extends Exception {

    public DomainCheckedException(String message) {
        super(message);
    }

    public DomainCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

}

