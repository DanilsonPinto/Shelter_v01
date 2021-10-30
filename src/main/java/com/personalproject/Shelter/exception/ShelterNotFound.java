package com.personalproject.Shelter.exception;

public class ShelterNotFound extends RuntimeException {
    public ShelterNotFound() {
        super("Shelter Not Found");
    }

    public ShelterNotFound(String message) {
        super(message);
    }
}