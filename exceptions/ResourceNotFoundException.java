package com.crud_rest_api.product_catlog_backend.exceptions;
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}