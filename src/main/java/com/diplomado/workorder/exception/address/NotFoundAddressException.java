package com.diplomado.workorder.exception.address;

import com.diplomado.workorder.exception.ApplicationException;

public class NotFoundAddressException extends ApplicationException {
  
  public NotFoundAddressException(String message) {
    super(message);
  }
}
