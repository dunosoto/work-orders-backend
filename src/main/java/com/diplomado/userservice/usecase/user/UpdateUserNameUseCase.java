package com.diplomado.userservice.usecase.user;


import com.diplomado.userservice.api.request.user.UpdateUserNameRequest;
import com.diplomado.userservice.api.response.user.UserResponse;
import com.diplomado.userservice.common.Message;
import com.diplomado.userservice.domain.User;
import com.diplomado.userservice.exception.NotFoundUserException;
import com.diplomado.userservice.mapper.UserMapper;
import com.diplomado.userservice.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateUserNameUseCase {

  @Autowired
  private IUserService userService;
  
  private UserMapper userMapper;
  
  private Message message;
  
  public UserResponse execute(UpdateUserNameRequest request, Long userId) {
    validateUserId(userId);
    
    return new UserResponse(
      userMapper.userToUserDto(userService.updateUserNameByUserId(request.getUserName(), userId))
    );
  }
  
  private void validateUserId(Long userId) {
    Optional<User> optionalUser = userService.findById(userId);
    
    if (optionalUser.isEmpty()) {
      throw new NotFoundUserException(message.getMessage("User.not.found"));
    }
  }

}
