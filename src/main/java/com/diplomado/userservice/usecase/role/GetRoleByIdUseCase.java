package com.diplomado.userservice.usecase.role;


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
public class GetRoleByIdUseCase {

  private IRoleService roleService;
  private RoleMapper roleMapper;
  private Message message;
  
  public RoleResponse execute(Long roleId) {
    Role role = roleService.findById(roleId);
  
    if ( role == null) {
      throw new NotFoundRoleException(message.getMessage("Role.not.found"));
    }
    return new RoleResponse(roleMapper.roleToRoleDto(role));
  }
}
