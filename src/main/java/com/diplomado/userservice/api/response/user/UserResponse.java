package com.diplomado.userservice.api.response.user;

import com.diplomado.userservice.api.constant.ResponseConstant;
import com.diplomado.userservice.api.dto.user.UserDto;
import com.diplomado.userservice.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserResponse extends CommonResponse {
  
  private UserDto user;
  
  public UserResponse(UserDto user) {
    super(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
    this.user = user;
  }
}
