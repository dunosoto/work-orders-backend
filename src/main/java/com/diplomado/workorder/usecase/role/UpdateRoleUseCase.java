package com.diplomado.workorder.usecase.role;

import com.diplomado.workorder.api.request.role.UpdateRoleRequest;
import com.diplomado.workorder.api.response.role.RoleResponse;
import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.mapper.role.RoleMapper;
import com.diplomado.workorder.service.role.IRoleService;
import com.diplomado.workorder.usecase.role.util.RoleValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateRoleUseCase {

  private RoleValidatorUtil roleValidatorUtil;
  private RoleMapper roleMapper;
  private IRoleService roleService;
  
  public RoleResponse execute(UpdateRoleRequest request, Long roleId) {
    Role role = roleValidatorUtil.validateRoleId(roleId);

    role.setName(request.getName());

    return new RoleResponse(roleMapper.roleToRoleDto(roleService.update(role)));
  }
}
