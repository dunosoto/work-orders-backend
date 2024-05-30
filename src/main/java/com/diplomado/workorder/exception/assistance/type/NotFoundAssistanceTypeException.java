package com.diplomado.workorder.exception.assistance.type;

import com.diplomado.workorder.exception.ApplicationException;

public class NotFoundAssistanceTypeException extends ApplicationException {
  
  public NotFoundAssistanceTypeException(String message) {
    super(message);
  }
}
