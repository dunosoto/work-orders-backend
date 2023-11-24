package com.diplomado.userservice.usecase.role;

import com.diplomado.userservice.api.dto.role.RoleDto;
import com.diplomado.userservice.api.response.role.RoleListResponse;
import com.diplomado.userservice.domain.Role;
import com.diplomado.userservice.mapper.RoleMapper;
import com.diplomado.userservice.service.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllRolesUseCase {

  private IRoleService roleService;
  private RoleMapper roleMapper;
  
  public RoleListResponse execute() {
    List<Role> roles = roleService.getAll();
    
    List<RoleDto> roleList = roles.stream().map(roleMapper::roleToRoleDto).collect(Collectors.toList());
    
    return new RoleListResponse(roleList);
  }
}
