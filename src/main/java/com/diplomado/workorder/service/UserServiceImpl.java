package com.diplomado.workorder.service;

import com.diplomado.workorder.domain.User;
import com.diplomado.workorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
  
  @Autowired
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
  
  @Override
  public User updateUserNameByUserId(String newUserName, Long userId) {
    return userRepository.updateUserNameByUserId(newUserName, userId);
  }

  @Override
  public void delete(User user) {
    userRepository.delete(user);
  }
}
