package com.diplomado.userservice.api.constant;

public class ResponseConstant {
  
  public static class StatusCodeResponse {
    public static final String SUCCESS_CODE = "200";
    public static final String SUCCESS_MSG = "Success";
    
    private StatusCodeResponse() {
      throw new IllegalStateException("Failed");
    }
  }
}
