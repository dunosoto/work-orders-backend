package com.diplomado.userservice.usecase.user;


import com.diplomado.userservice.api.response.user.UserListResponse;
import com.diplomado.userservice.domain.User;
import com.diplomado.userservice.mapper.UserMapper;
import com.diplomado.userservice.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllUsersUseCase {

  private IUserService userService;
  private UserMapper userMapper;
  
  public UserListResponse execute() {
  
    List<User> userList = userService.getAll();
    
    return new UserListResponse(
      userList.stream().map(user ->
        userMapper.userToUserDto(user)
      ).collect(Collectors.toList())
    );
  }
}
