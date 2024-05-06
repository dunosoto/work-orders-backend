package com.diplomado.workorder.service.user;

import com.diplomado.workorder.domain.user.UserRole;

import java.util.List;
import java.util.Optional;

public interface IUserRoleService {
  
  List<UserRole> saveAll(Iterable<UserRole> userRoles);
  
  UserRole save(UserRole userRole);
  
  Optional<UserRole> findById(Long userRoleId);
  
}
