package com.diplomado.userservice.usecase.role;

import com.diplomado.userservice.common.Message;
import com.diplomado.userservice.domain.Role;
import com.diplomado.userservice.exception.NotFoundRoleException;
import com.diplomado.userservice.service.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteRoleUseCase {
  
  private IRoleService roleService;
  private Message message;
  
  
  public void execute(Long id) {
    Role role = roleService.findById(id);
  
    if ( role == null) {
      throw new NotFoundRoleException(message.getMessage("Role.not.found"));
    }
    
    roleService.deleteById(id);
    
  }
  
}
