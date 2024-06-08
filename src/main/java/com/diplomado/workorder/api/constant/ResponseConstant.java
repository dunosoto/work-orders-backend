package com.diplomado.workorder.api.constant;

public class ResponseConstant {
  
  public static class StatusCodeResponse {

    //CODE RESPONSE
    public static final String SUCCESS_CODE = "200";
    public static final boolean SUCCESS_STATUS = true;
    public static final String CREATED_CODE = "201";
    
    //MESSAGES
    public static final String SUCCESS_MSG = "Success";
    public static final String GET_ALL_SUCCESS_MSG = "Get record list successfully.";
    public static final String CREATED_SUCCESS_MSG = "Record created successfully.";
    public static final String UPDATED_SUCCESS_MSG = "Record updated successfully.";
    public static final String GET_RECORD_SUCCESS_MSG = "Get a record successfully.";
    
    private StatusCodeResponse() {
      throw new IllegalStateException("Failed");
    }
  }
}
