package com.diplomado.userservice.service;

import com.diplomado.userservice.domain.UserDetail;
import com.diplomado.userservice.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements IUserDetailService {
  
  @Autowired
  private UserDetailRepository userDetailRepository;
  
  @Override
  public UserDetail save(UserDetail detail) {
    return userDetailRepository.save(detail);
  }
}
