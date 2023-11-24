package com.diplomado.userservice.usecase.user;


import com.diplomado.userservice.api.dto.role.RoleDto;
import com.diplomado.userservice.api.dto.user.UserDetailDto;
import com.diplomado.userservice.api.response.user.UserResponse;
import com.diplomado.userservice.common.Message;
import com.diplomado.userservice.domain.Role;
import com.diplomado.userservice.domain.User;
import com.diplomado.userservice.domain.UserRole;
import com.diplomado.userservice.exception.NotFoundUserException;
import com.diplomado.userservice.mapper.RoleMapper;
import com.diplomado.userservice.mapper.UserDetailMapper;
import com.diplomado.userservice.mapper.UserMapper;
import com.diplomado.userservice.repository.UserDetailRepository;
import com.diplomado.userservice.service.IUserService;
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
