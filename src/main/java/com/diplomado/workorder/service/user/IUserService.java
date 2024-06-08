package com.diplomado.workorder.service.user;

import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.service.BusinessServiceCommand;

import java.util.Optional;

public interface IUserService extends BusinessServiceCommand<User, Long> {
  
  void delete(User user);
//  User updateUserNameByUserId(String newUserName, Long userId);
  
  Optional<User> getUserByEmailAndPassword(String email, String password);
}
