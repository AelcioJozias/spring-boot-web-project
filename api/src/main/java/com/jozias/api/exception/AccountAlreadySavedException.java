package com.jozias.api.exception;

public class AccountAlreadySavedException extends EntityInUseException {
    public AccountAlreadySavedException(String message) {
        super(message);
    }
}
