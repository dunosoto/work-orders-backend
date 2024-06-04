package com.diplomado.workorder.usecase.role;

import com.diplomado.workorder.api.request.role.CreateRoleRequest;
import com.diplomado.workorder.api.response.role.CreateRoleResponse;
import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.mapper.role.RoleMapper;
import com.diplomado.workorder.service.role.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateRoleUseCase {

  private IRoleService roleService;
  private RoleMapper roleMapper;

  public CreateRoleResponse execute(CreateRoleRequest request) {

    Role role = roleService.save(roleMapper.toRole(request));
    
    return  new CreateRoleResponse(roleMapper.roleToRoleDto(role));
  }
}
