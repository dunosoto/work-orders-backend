package com.diplomado.workorder.usecase.user;

import com.diplomado.workorder.api.request.user.CreateUserRequest;
import com.diplomado.workorder.api.response.user.CreateUserResponse;
import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.exception.role.NotFoundRoleException;
import com.diplomado.workorder.mapper.role.RoleMapper;
import com.diplomado.workorder.mapper.user.UserMapper;
import com.diplomado.workorder.service.role.IRoleService;
import com.diplomado.workorder.service.user.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CreateUserUseCase {

  private IUserService userService;
  private IRoleService roleService;
  private UserMapper userMapper;
  private RoleMapper roleMapper;
  
  public CreateUserResponse execute(CreateUserRequest request) {
    Role role = validateRoleId(request.getRoleId());
    
    User user = userService.save(userMapper.createUserRequestToUser(request, role));
    
    return new CreateUserResponse(
      userMapper.fromUserToUserDto(
        user,
        roleMapper.roleToRoleDto(user.getRole())
      )
    );
  }

  private Role validateRoleId(Long roleId) {
    Optional<Role> role = roleService.findById(roleId);
    
    if (role.isEmpty()) {
      throw new NotFoundRoleException("not exist a role with the id: ".concat(roleId.toString()));
    }
    
    return role.get();
  }
}
