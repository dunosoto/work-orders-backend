package com.diplomado.userservice.api.response;


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
