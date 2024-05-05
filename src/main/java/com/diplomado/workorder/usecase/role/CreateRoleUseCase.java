package com.diplomado.workorder.usecase.role;

import com.diplomado.workorder.api.request.role.CreateRoleRequest;
import com.diplomado.workorder.api.response.role.CreateRoleResponse;
import com.diplomado.workorder.domain.Role;
import com.diplomado.workorder.mapper.RoleMapper;
import com.diplomado.workorder.service.role.RoleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateRoleUseCase {
  
  @Autowired
  private RoleServiceImpl roleService;
  private RoleMapper roleMapper;
  
  public CreateRoleResponse execute(CreateRoleRequest request) {

    Role role = roleService.save(roleMapper.toRole(request));
    
    return  new CreateRoleResponse(roleMapper.roleToRoleDto(role));
  }

}
