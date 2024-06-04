package com.diplomado.workorder.api.response.role;


import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.role.RoleDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleListResponse extends CommonResponse {

  private List<RoleDto> roles;
  
  public RoleListResponse(List<RoleDto> roleList) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_CODE,
    ResponseConstant.StatusCodeResponse.GET_ALL_SUCCESS_MSG);
    this.roles = roleList;
  }
}
