package com.jozias.api.exception;

public class AccountNotFoundException extends EntityNotFoundException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
