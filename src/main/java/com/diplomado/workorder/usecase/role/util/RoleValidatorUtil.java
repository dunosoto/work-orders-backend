package com.diplomado.workorder.usecase.role.util;

import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.exception.role.NotFoundRoleException;
import com.diplomado.workorder.service.role.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleValidatorUtil {
  
  private IRoleService roleService;
  private Message message;

  public Role validateRoleId(Long roleId) {
    Optional<Role> role = roleService.findById(roleId);
  
    if (role.isEmpty()) {
      throw new NotFoundRoleException(message.getMessage("Role.not.found"));
    }
    
    return role.get();
  }
}
