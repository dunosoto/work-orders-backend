package com.diplomado.workorder.usecase.role;

import com.diplomado.workorder.api.dto.role.RoleDto;
import com.diplomado.workorder.api.response.role.RoleListResponse;
import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.mapper.role.RoleMapper;
import com.diplomado.workorder.service.role.IRoleService;
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
