package com.diplomado.workorder.usecase.user.util;

import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.exception.user.NotFoundUserException;
import com.diplomado.workorder.service.user.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserValidatorUtil {

  private IUserService userService;
  private Message message;
  
  public User validateUserId(Long userId) {
    Optional<User> optionalUser = userService.findById(userId);
    
    if (optionalUser.isEmpty()) {
      throw new NotFoundUserException(message.getMessage("User.not.found"));
    }

    return optionalUser.get();
  }
}
