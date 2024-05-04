package com.diplomado.workorder.api.response.user;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.user.UserDto;
import com.diplomado.workorder.api.response.CommonResponse;
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
