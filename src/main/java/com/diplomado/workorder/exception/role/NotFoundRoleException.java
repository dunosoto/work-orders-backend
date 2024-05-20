package com.diplomado.workorder.exception.role;

import com.diplomado.workorder.exception.ApplicationException;

public class NotFoundRoleException extends ApplicationException {
  
  public NotFoundRoleException(String message) { super(message); }
}
