package com.diplomado.workorder.api.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonResponse {
  
  private String statusCode;
  private String message;
}
