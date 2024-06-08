package com.diplomado.workorder.api.response.auth;

import com.diplomado.workorder.api.dto.user.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

  private String key;
  private UserDto user;
  
  public LoginResponse(UserDto userDto) {
    this.user = userDto;
  }
}
