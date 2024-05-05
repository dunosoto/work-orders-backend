package com.diplomado.workorder.service.group;

import com.diplomado.workorder.domain.group.Group;

import java.util.List;
import java.util.Optional;

public interface IGroupService {
  
  Group save(Group group);
  List<Group> getAll();
  Optional<Group> findById(Long id);
  Group update(Group group);
}
