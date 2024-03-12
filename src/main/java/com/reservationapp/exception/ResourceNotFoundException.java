package com.reservationapp.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String busNotAdded) {
        super(busNotAdded);
    }
}
