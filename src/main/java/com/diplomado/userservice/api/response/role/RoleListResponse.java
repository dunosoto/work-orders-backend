package com.diplomado.userservice.api.response.role;


import com.diplomado.userservice.api.constant.ResponseConstant;
import com.diplomado.userservice.api.dto.role.RoleDto;
import com.diplomado.userservice.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleListResponse extends CommonResponse {

  private List<RoleDto> roles;
  
  public RoleListResponse(List<RoleDto> roleList) {
    super(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
    this.roles = roleList;
  }
}
