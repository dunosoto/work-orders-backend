package com.diplomado.workorder.service.role;

import com.diplomado.workorder.domain.Role;
import com.diplomado.workorder.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

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
  public Optional<Role> findById(Long id) {
    return roleRepository.findById(id);
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
