package com.diplomado.workorder.exception.template;

import com.diplomado.workorder.exception.ApplicationException;

public class NotFoundTemplateException extends ApplicationException {
  
  public NotFoundTemplateException(String message) {
    super(message);
  }
}
