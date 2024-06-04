package com.diplomado.workorder.api.response.role;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.role.RoleDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoleResponse extends CommonResponse {
  
  private RoleDto role;
  
  public CreateRoleResponse(RoleDto role) {
    super(
      ResponseConstant.StatusCodeResponse.CREATED_CODE,
      ResponseConstant.StatusCodeResponse.CREATED_SUCCESS_MSG
    );
    this.role = role;
  }
}
