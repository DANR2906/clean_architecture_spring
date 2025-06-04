package com.decode_code.clean_architecture_spring.domain.exceptions;

public class StorageException extends DomainCheckedException {

    private static final String STORAGE_EXCEPTION_MSG = "Storage exception error";

    public StorageException(final String message, Throwable e) {
        super(message, e);
    }

    public StorageException(Throwable e) {
        super(STORAGE_EXCEPTION_MSG, e);
    }

}

