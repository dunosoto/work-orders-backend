package com.diplomado.workorder.usecase.userrole;


import com.diplomado.workorder.api.request.userrole.UpdateActiveRequest;
import com.diplomado.workorder.api.response.userrole.UserRoleResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.user.UserRole;
import com.diplomado.workorder.exception.NotFoundUserRoleException;
import com.diplomado.workorder.service.user.IUserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateUserRoleActiveUseCase {

  @Autowired
  private IUserRoleService userRoleService;
  
  private Message message;
  
  public UserRoleResponse execute(UpdateActiveRequest request, Long userRoleId) {
    UserRole userRole = validateUserRole(userRoleId);

    userRole.setActive(request.isActive());
    
    userRoleService.save(userRole);
    
    
    return new UserRoleResponse();
    
  }
  
  private UserRole validateUserRole(Long userRoleId) {
    Optional<UserRole> optionalUserRole = userRoleService.findById(userRoleId);
  
    if (optionalUserRole.isEmpty()) {
      throw new NotFoundUserRoleException(message.getMessage("User.role.not.found"));
    }
  
    return optionalUserRole.get();
  }

}
