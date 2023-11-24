package com.diplomado.userservice.usecase.role;

import com.diplomado.userservice.api.request.role.CreateRoleRequest;
import com.diplomado.userservice.api.response.role.CreateRoleResponse;
import com.diplomado.userservice.domain.Role;
import com.diplomado.userservice.mapper.RoleMapper;
import com.diplomado.userservice.service.RoleServiceImpl;
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
