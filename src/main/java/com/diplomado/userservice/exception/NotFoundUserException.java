package com.diplomado.userservice.exception;

public class NotFoundUserException extends ApplicationException {
  
  public NotFoundUserException(String message) {
    super(message);
  }
}
