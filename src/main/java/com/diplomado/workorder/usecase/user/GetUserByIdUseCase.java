package com.diplomado.workorder.usecase.user;


import com.diplomado.workorder.api.dto.role.RoleDto;
import com.diplomado.workorder.api.response.user.UserResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.Role;
import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.domain.user.UserRole;
import com.diplomado.workorder.exception.NotFoundUserException;
import com.diplomado.workorder.mapper.RoleMapper;
import com.diplomado.workorder.mapper.UserDetailMapper;
import com.diplomado.workorder.mapper.UserMapper;
import com.diplomado.workorder.service.user.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetUserByIdUseCase {

  @Autowired
  private IUserService userService;
  
  private UserMapper userMapper;
  private RoleMapper roleMapper;
  private UserDetailMapper userDetailMapper;
  private Message message;
  
  public UserResponse execute(Long userId) {
    User user = validateUserId(userId);
    
    return new UserResponse(userMapper.fromUserToUserDto(
      user,
      userDetailMapper.toUserDetailDto(user.getUserDetail()),
      composeRoleDto(getRoles(user.getUserRoles()))
    ));
  }
  
  private List<RoleDto> composeRoleDto(List<Role> roles) {
    return roles.stream().map(roleMapper::roleToRoleDto).collect(Collectors.toList());
  }
  
  private List<Role> getRoles(List<UserRole> userRoleList) {
    List<Role> roles = new ArrayList<>();
    userRoleList.forEach(userRole -> {
      if (userRole.isActive()) roles.add(userRole.getRole());
    });
    return roles;
    
  }
  
  private User validateUserId(Long userId) {
    Optional<User> optionalUser = userService.findById(userId);
    
    if (optionalUser.isEmpty()) {
      throw new NotFoundUserException(message.getMessage("User.not.found"));
    }
    
    return optionalUser.get();
  }
}
