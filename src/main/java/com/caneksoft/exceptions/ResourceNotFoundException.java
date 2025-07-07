package com.caneksoft.exceptions;

public class ResourceNotFoundException extends RuntimeException {
     public ResourceNotFoundException(String message) {
        super(message);
    }
}
