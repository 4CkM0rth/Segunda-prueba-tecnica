package com.backend.infrastrcuture.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + "with ID" + id + "was not found");
    }
}
