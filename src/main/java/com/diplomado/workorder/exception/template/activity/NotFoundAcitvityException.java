package com.diplomado.workorder.exception.template.activity;

import com.diplomado.workorder.exception.ApplicationException;

public class NotFoundAcitvityException extends ApplicationException {
  
  public NotFoundAcitvityException(String message) {
    super(message);
  }
}
