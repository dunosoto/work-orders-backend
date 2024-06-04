package com.diplomado.workorder.usecase.user;


import com.diplomado.workorder.api.request.user.UpdateUserRequest;
import com.diplomado.workorder.api.response.user.UserResponse;
import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.mapper.user.UserMapper;
import com.diplomado.workorder.service.user.IUserService;
import com.diplomado.workorder.usecase.user.util.UserValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserUseCase {

  private IUserService userService;
  private UserMapper userMapper;
  private UserValidatorUtil userValidatorUtil;
  
  public UserResponse execute(UpdateUserRequest request, Long userId) {
    User user = userValidatorUtil.validateUserId(userId);
    
    User updatedUser = compose(user, request);
    
    return new UserResponse(userMapper.userToUserDto(userService.update(updatedUser)));
  }
  
  private User compose(User user, UpdateUserRequest request) {

    user.setFirstName((request.getFirstName() == null) ? user.getFirstName() : request.getFirstName());
    user.setLastName((request.getLastName() == null) ? user.getLastName() : request.getLastName());
    user.setPassword((request.getPassword() == null) ? user.getPassword() : request.getPassword());
    user.setEmail((request.getEmail() == null) ? user.getEmail() : request.getEmail());

    return user;
  }
}
