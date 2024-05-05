package com.diplomado.workorder.usecase.role;

import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.Role;
import com.diplomado.workorder.exception.NotFoundRoleException;
import com.diplomado.workorder.service.role.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteRoleUseCase {
  
  private IRoleService roleService;
  private Message message;
  
  
  public void execute(Long id) {
    Optional<Role> role = roleService.findById(id);
  
    if (role.isEmpty()) {
      throw new NotFoundRoleException(message.getMessage("Role.not.found"));
    }
    
    roleService.deleteById(id);
    
  }
  
}
