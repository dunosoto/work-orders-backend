package com.diplomado.workorder.exception.assistance;

import com.diplomado.workorder.exception.ApplicationException;

public class NotFoundAssistanceException extends ApplicationException {
  
  public NotFoundAssistanceException(String message) {
    super(message);
  }
}
