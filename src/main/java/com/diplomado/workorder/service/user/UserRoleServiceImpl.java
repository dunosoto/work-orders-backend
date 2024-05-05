package com.diplomado.workorder.service.user;

import com.diplomado.workorder.domain.user.UserRole;
import com.diplomado.workorder.repository.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
  
  @Autowired
  private UserRoleRepository userRoleRepository;
  
  @Override
  public UserRole save(UserRole userRole) {
    return userRoleRepository.save(userRole);
  }
  
  @Override
  public List<UserRole> saveAll(Iterable<UserRole> userRoles) {
    return userRoleRepository.saveAll(userRoles);
  }
  @Override
  public Optional<UserRole> findById(Long userRoleId) {
    return userRoleRepository.findById(userRoleId);
  }
}
