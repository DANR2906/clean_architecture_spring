package com.decode_code.clean_architecture_spring.application.exceptions;

public class ApplicationUnCheckedException extends RuntimeException {

    public ApplicationUnCheckedException(String message) {
        super(message);
    }

    public ApplicationUnCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

}

