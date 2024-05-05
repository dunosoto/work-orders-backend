package com.diplomado.workorder.service.group;

import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.repository.group.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements IGroupService {
  
  private GroupRepository groupRepository;
  
  @Override
  public Group save(Group group) {
    return groupRepository.save(group);
  }
  
  @Override
  public List<Group> getAll() {
    return groupRepository.findAll();
  }
  
  @Override
  public Optional<Group> findById(Long id) {
    return groupRepository.findById(id);
  }
  
  @Override
  public Group update(Group group) {
    return null;
  }
}
