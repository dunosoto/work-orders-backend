package com.diplomado.workorder.usecase.role;


import com.diplomado.workorder.api.response.role.RoleResponse;
import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.mapper.role.RoleMapper;
import com.diplomado.workorder.usecase.role.util.RoleValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetRoleByIdUseCase {

  private RoleValidatorUtil roleValidatorUtil;
  private RoleMapper roleMapper;

  public RoleResponse execute(Long roleId) {
    Role role = roleValidatorUtil.validateRoleId(roleId);
    
    return new RoleResponse(roleMapper.roleToRoleDto(role));
  }
}
