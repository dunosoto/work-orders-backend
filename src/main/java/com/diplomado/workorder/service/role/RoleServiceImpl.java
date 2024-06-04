package com.diplomado.workorder.service.role;

import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.repository.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements IRoleService {

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
