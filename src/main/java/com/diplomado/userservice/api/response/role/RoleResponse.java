package com.diplomado.userservice.api.response.role;


import com.diplomado.userservice.api.constant.ResponseConstant;
import com.diplomado.userservice.api.dto.role.RoleDto;
import com.diplomado.userservice.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponse extends CommonResponse {
  
  private RoleDto role;
  
  public RoleResponse(RoleDto role) {
    super(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
    this.role = role;
  }
  
}
