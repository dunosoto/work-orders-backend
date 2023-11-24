package com.diplomado.userservice.api.response.user;

import com.diplomado.userservice.api.constant.ResponseConstant;
import com.diplomado.userservice.api.dto.user.UserDto;
import com.diplomado.userservice.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserListResponse extends CommonResponse {
  
  List<UserDto> userList;
  
  public UserListResponse(List<UserDto> userList) {
    super(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
    this.userList = userList;
  }
}
