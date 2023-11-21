package com.diplomado.userservice.service;

import com.diplomado.userservice.domain.Role;
import com.diplomado.userservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService{

  @Autowired
  private RoleRepository roleRepository;
  
  @Override
  public Role save(Role role) {
    return roleRepository.save(role);
  }
  
  @Override
  public List<Role> getAll() {
    return roleRepository.findAll();
  }
  
  @Override
  public Role findById(Long id) {
    return roleRepository.findById(id).orElse(null);
  }
  
  @Override
  public Role update(Role role) {
    return roleRepository.save(role);
  }

  @Override
  public void deleteById(Long id) {
    roleRepository.deleteById(id);
  }

}
