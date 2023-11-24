package com.diplomado.userservice.usecase.user;


import com.diplomado.userservice.api.request.user.UpdateUserRequest;
import com.diplomado.userservice.api.response.user.UserResponse;
import com.diplomado.userservice.common.Message;
import com.diplomado.userservice.domain.User;
import com.diplomado.userservice.exception.NotFoundUserException;
import com.diplomado.userservice.mapper.UserDetailMapper;
import com.diplomado.userservice.mapper.UserMapper;
import com.diplomado.userservice.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateUserUseCase {

  @Autowired
  private IUserService userService;
  
  private Message message;
  private UserMapper userMapper;
  
  public UserResponse execute(UpdateUserRequest request, Long userId) {
    User user = validateUserId(userId);
    
    User updatedUser = compose(user, request);
    
    return new UserResponse(userMapper.userToUserDto(userService.update(updatedUser)));
  }
  
  private User validateUserId(Long userId) {
    Optional<User> optionalUser = userService.findById(userId);
    
    if (optionalUser.isEmpty()) {
      throw new NotFoundUserException(message.getMessage("User.not.found"));
    }
    
    return optionalUser.get();
  }
  
  private User compose(User user, UpdateUserRequest request) {
    
    user.setUserName((request.getUserName() == null) ? user.getUserName() : request.getUserName());
    user.setPassword((request.getEmail() == null) ? user.getEmail() : request.getEmail());
    user.setEmail((request.getEmail() == null) ? user.getEmail() : request.getEmail());
    
    return user;
  }
}
