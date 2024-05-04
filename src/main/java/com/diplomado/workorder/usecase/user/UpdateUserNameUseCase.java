package com.diplomado.workorder.usecase.user;


import com.diplomado.workorder.api.request.user.UpdateUserNameRequest;
import com.diplomado.workorder.api.response.user.UserResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.User;
import com.diplomado.workorder.exception.NotFoundUserException;
import com.diplomado.workorder.mapper.UserMapper;
import com.diplomado.workorder.service.IUserService;
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
