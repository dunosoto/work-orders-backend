package com.diplomado.workorder.service.user;

import com.diplomado.workorder.domain.user.UserDetail;
import com.diplomado.workorder.repository.user.UserDetailRepository;
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
