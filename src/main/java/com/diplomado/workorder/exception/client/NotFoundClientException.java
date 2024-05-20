package com.diplomado.workorder.exception.client;

import com.diplomado.workorder.exception.ApplicationException;

public class NotFoundClientException extends ApplicationException {
  
  public NotFoundClientException(String message) {
    super(message);
  }
}
