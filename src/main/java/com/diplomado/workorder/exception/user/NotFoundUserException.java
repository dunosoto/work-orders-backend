package com.diplomado.workorder.exception.user;

import com.diplomado.workorder.exception.ApplicationException;

public class NotFoundUserException extends ApplicationException {
  
  public NotFoundUserException(String message) {
    super(message);
  }
}
