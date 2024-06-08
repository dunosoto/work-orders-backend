package com.diplomado.workorder.usecase.auth;

import com.diplomado.workorder.api.request.auth.LoginRequest;
import com.diplomado.workorder.api.response.auth.LoginResponse;
import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.mapper.role.RoleMapper;
import com.diplomado.workorder.mapper.user.UserMapper;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import com.diplomado.workorder.usecase.user.util.UserValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUseCase implements BusinessLogicCommand<LoginResponse, LoginRequest> {
  
  private UserValidatorUtil userValidatorUtil;
  private UserMapper userMapper;
  private RoleMapper roleMapper;

  @Override
  public LoginResponse execute(LoginRequest loginRequest) {
    User user = userValidatorUtil.validateLogin(loginRequest);

    return new LoginResponse(
      userMapper.fromUserToUserDto(user, roleMapper.roleToRoleDto(user.getRole()))
    );
  }
}
