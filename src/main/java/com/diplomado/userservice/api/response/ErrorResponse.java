package com.diplomado.userservice.api.response;

import java.time.LocalDateTime;

public class ErrorResponse extends CommonResponse {
  String url;
  String timestamp;
  
  public ErrorResponse( String statusCode, String message, String url ) {
    super(statusCode, message);
    this.url = url;
    this.timestamp = LocalDateTime.now().toString();
  }
}
