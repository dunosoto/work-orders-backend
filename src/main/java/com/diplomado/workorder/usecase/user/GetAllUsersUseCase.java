package com.diplomado.workorder.usecase.user;


import com.diplomado.workorder.api.dto.user.UserDto;
import com.diplomado.workorder.api.response.user.UserListResponse;
import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.mapper.role.RoleMapper;
import com.diplomado.workorder.mapper.user.UserMapper;
import com.diplomado.workorder.service.user.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllUsersUseCase {

  private IUserService userService;
  private UserMapper userMapper;
  private RoleMapper roleMapper;

  public UserListResponse execute() {
    List<User> userList = userService.getAll();
    List<UserDto> userDtoList;

    userDtoList = userList.stream().map(user -> {
      return userMapper.fromUserToUserDto(user, roleMapper.roleToRoleDto(user.getRole()));
    }).collect(Collectors.toList());

    return new UserListResponse(userDtoList);
  }
}
