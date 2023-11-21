package com.diplomado.userservice.usecase.user;


import com.diplomado.userservice.api.request.user.CreateUserRequest;
import com.diplomado.userservice.api.response.user.CreateUserResponse;
import com.diplomado.userservice.domain.User;
import com.diplomado.userservice.domain.UserDetail;
import com.diplomado.userservice.exception.NotFoundRoleException;
import com.diplomado.userservice.mapper.UserDetailMapper;
import com.diplomado.userservice.mapper.UserMapper;
import com.diplomado.userservice.service.IRoleService;
import com.diplomado.userservice.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreateUserUseCase {

  @Autowired
  private IUserService userService;
  
  @Autowired
  private IRoleService roleService;
  
  private UserMapper userMapper;
  private UserDetailMapper userDetailMapper;
  
  
  public CreateUserResponse execute(CreateUserRequest request) {
    validateRoleIds(request.getRoleIds());
    
    UserDetail detail = userDetailMapper.toUserDetail(request);
    User user = userService.save(userMapper.createUserRequestToUser(request, detail));
  
    return new CreateUserResponse(
      userMapper.fromCreateUserResponseToUserDto(
        userService.save(user),
        userDetailMapper.toUserDetailDto(user.getUserDetail())
      )
    );
  }
  
  private void validateRoleIds(List<Long> roleIds) {
    roleIds.forEach(roleId -> {
      if (roleService.findById(roleId) == null) {
        throw new NotFoundRoleException("not exist a role with the id: ".concat(roleId.toString()));
      }
    });
  }
  
}
