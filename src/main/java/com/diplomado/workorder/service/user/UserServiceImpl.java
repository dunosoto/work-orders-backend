package com.diplomado.workorder.service.user;

import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
  
  private UserRepository userRepository;
  
  @Override
  public User save(User user) {
    return userRepository.save(user);
  }
  
  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }
  
  @Override
  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }
  
  @Override
  public User update(User user) {
    return userRepository.save(user);
  }
  
//  @Override
//  public User updateUserNameByUserId(String newUserName, Long userId) {
//    return userRepository.updateUserNameByUserId(newUserName, userId);
//  }

  @Override
  public void delete(User user) {
    userRepository.delete(user);
  }
  
  @Override
  public Optional<User> getUserByEmailAndPassword(String email, String password) {
    return userRepository.getUserByEmailAndPassword(email, password);
  }
}
