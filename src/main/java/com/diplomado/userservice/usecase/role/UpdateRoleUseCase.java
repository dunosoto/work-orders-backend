package com.diplomado.userservice.usecase.role;

import com.diplomado.userservice.api.request.role.UpdateRoleRequest;
import com.diplomado.userservice.api.response.role.RoleResponse;
import com.diplomado.userservice.common.Message;
import com.diplomado.userservice.domain.Role;
import com.diplomado.userservice.exception.NotFoundRoleException;
import com.diplomado.userservice.mapper.RoleMapper;
import com.diplomado.userservice.service.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateRoleUseCase {

  private RoleMapper roleMapper;
  private IRoleService roleService;
  private Message message;
  
  public RoleResponse execute(UpdateRoleRequest request, Long id) {
    Role role = roleService.findById(id);
    
    if ( role == null) {
      throw new NotFoundRoleException(message.getMessage("Role.not.found"));
    }
    
    role.setName(request.getName());
    
    return new RoleResponse(roleMapper.roleToRoleDto(roleService.update(role)));
  }
}
