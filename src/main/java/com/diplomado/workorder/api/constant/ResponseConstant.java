package com.diplomado.workorder.api.constant;

public class ResponseConstant {
  
  public static class StatusCodeResponse {
    public static final String SUCCESS_CODE = "200";
    public static final String SUCCESS_MSG = "Success";
    public static final String CREATED_CODE = "201";
    
    private StatusCodeResponse() {
      throw new IllegalStateException("Failed");
    }
  }
}
