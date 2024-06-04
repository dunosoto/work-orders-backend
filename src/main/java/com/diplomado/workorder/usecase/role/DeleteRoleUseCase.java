package com.diplomado.workorder.usecase.role;

import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.service.role.IRoleService;
import com.diplomado.workorder.usecase.role.util.RoleValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteRoleUseCase {
  
  private RoleValidatorUtil roleValidatorUtil;
  private IRoleService roleService;
  
  public void execute(Long id) {
    Role role = roleValidatorUtil.validateRoleId(id);
  
    roleService.deleteById(role.getId());
  }
}
