package com.diplomado.workorder.service.user;

import com.diplomado.workorder.domain.user.UserGroup;
import com.diplomado.workorder.repository.user.UserGroupRepository;

import java.util.List;
import java.util.Optional;

public class UserGroupServiceImpl implements IUserGroupService {
  
  private UserGroupRepository userGroupRepository;
  
  @Override
  public List<UserGroup> saveAll(Iterable<UserGroup> members) {
    return userGroupRepository.saveAll(members);
  }
  
  @Override
  public UserGroup save(UserGroup UserGroup) {
    return null;
  }
  
  @Override
  public Optional<UserGroup> findById(Long memberId) {
    return Optional.empty();
  }
}
