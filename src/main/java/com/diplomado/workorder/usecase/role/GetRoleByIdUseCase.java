package com.diplomado.workorder.usecase.role;


import com.diplomado.workorder.api.response.role.RoleResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.Role;
import com.diplomado.workorder.exception.NotFoundRoleException;
import com.diplomado.workorder.mapper.RoleMapper;
import com.diplomado.workorder.service.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetRoleByIdUseCase {

  private IRoleService roleService;
  private RoleMapper roleMapper;
  private Message message;
  
  public RoleResponse execute(Long roleId) {
    Optional<Role> role = roleService.findById(roleId);
  
    if (role.isEmpty()) {
      throw new NotFoundRoleException(message.getMessage("Role.not.found"));
    }
    return new RoleResponse(roleMapper.roleToRoleDto(role.get()));
  }
}
