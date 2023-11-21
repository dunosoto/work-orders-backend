package com.diplomado.userservice.exception;

public class ApplicationException extends RuntimeException {
  
  public ApplicationException(){}
  
  public ApplicationException(String message) { super(message); }
}
