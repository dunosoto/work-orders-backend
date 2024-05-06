package com.diplomado.workorder.service.user;

import com.diplomado.workorder.domain.user.UserGroup;

import java.util.List;
import java.util.Optional;

public interface IUserGroupService {
  
  List<UserGroup> saveAll(Iterable<UserGroup> members);
  
  UserGroup save(UserGroup UserGroup);
  
  Optional<UserGroup> findById(Long memberId);
}
