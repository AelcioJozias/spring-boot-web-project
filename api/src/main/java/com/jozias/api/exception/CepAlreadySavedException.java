package com.jozias.api.exception;

public class CepAlreadySavedException extends EntityInUseException {
  public CepAlreadySavedException(String message) {
    super(message);
  }
}
