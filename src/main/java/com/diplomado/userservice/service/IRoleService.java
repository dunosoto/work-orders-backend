package com.diplomado.userservice.service;

import com.diplomado.userservice.domain.Role;
import java.util.List;

public interface IRoleService {
  
  Role save(Role role);
  List<Role> getAll();
  Role findById(Long id);
  Role update(Role role);
  void deleteById(Long id);
}
