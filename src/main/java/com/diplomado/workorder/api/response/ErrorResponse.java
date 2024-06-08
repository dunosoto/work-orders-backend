package com.diplomado.workorder.api.response;

import java.time.LocalDateTime;

public class ErrorResponse {
  String url;
  String timestamp;
  String statusCode;
  String message;
  
  public ErrorResponse( String statusCode, String message, String url ) {
    this.url = url;
    this.statusCode = statusCode;
    this.message = message;
    this.timestamp = LocalDateTime.now().toString();
  }
}
