package com.diplomado.workorder.usecase.user;


import com.diplomado.workorder.api.response.user.UserResponse;
import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.mapper.role.RoleMapper;
import com.diplomado.workorder.mapper.user.UserMapper;
import com.diplomado.workorder.usecase.user.util.UserValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUserByIdUseCase {

  private UserValidatorUtil userValidatorUtil;
  private UserMapper userMapper;
  private RoleMapper roleMapper;
  
  public UserResponse execute(Long userId) {
    User user = userValidatorUtil.validateUserId(userId);

    return new UserResponse(userMapper.fromUserToUserDto(
      user,
      roleMapper.roleToRoleDto(user.getRole())
    ));
  }
}
