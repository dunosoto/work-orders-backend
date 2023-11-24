package com.diplomado.userservice.usecase.user;


import com.diplomado.userservice.common.Message;
import com.diplomado.userservice.domain.User;
import com.diplomado.userservice.exception.NotFoundUserException;
import com.diplomado.userservice.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteUserUseCase {
  
  @Autowired
  private IUserService userService;
  private Message message;
  
  public void execute(Long userId) {
    User user = validateUserId(userId);
    
    userService.delete(user);
  }
  
  private User validateUserId(Long userId) {
    Optional<User> optionalUser = userService.findById(userId);
    
    if (optionalUser.isEmpty()) {
      throw new NotFoundUserException(message.getMessage("User.not.found"));
    }
    return optionalUser.get();
  }
}
