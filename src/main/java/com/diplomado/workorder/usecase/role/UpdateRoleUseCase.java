package com.diplomado.workorder.usecase.role;

import com.diplomado.workorder.api.request.role.UpdateRoleRequest;
import com.diplomado.workorder.api.response.role.RoleResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.Role;
import com.diplomado.workorder.exception.NotFoundRoleException;
import com.diplomado.workorder.mapper.RoleMapper;
import com.diplomado.workorder.service.role.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateRoleUseCase {

  private RoleMapper roleMapper;
  private IRoleService roleService;
  private Message message;
  
  public RoleResponse execute(UpdateRoleRequest request, Long roleId) {
    Optional<Role> role = roleService.findById(roleId);
  
    if (role.isEmpty()) {
      throw new NotFoundRoleException(message.getMessage("Role.not.found"));
    }
    
    Role updatedRole = role.get();
    updatedRole.setName(request.getName());
    
    return new RoleResponse(roleMapper.roleToRoleDto(roleService.update(updatedRole)));
  }
}
