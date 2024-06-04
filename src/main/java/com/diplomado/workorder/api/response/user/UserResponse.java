package com.diplomado.workorder.api.response.user;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.user.UserDto;
import com.diplomado.workorder.api.response.CommonResponse;
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
