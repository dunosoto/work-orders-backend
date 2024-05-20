package com.diplomado.workorder.exception.user;

import com.diplomado.workorder.exception.ApplicationException;

public class NotFoundUserRoleException extends ApplicationException {
  
  public NotFoundUserRoleException(String message) {
    super(message);
  }
}
