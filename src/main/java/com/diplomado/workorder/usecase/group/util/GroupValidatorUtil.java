package com.diplomado.workorder.usecase.group.util;

import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.exception.user.NotFoundUserException;
import com.diplomado.workorder.service.group.IGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupValidatorUtil {
  
  private IGroupService groupService;
  private Message message;
  
  public Group validateGroupId(Long groupId) {
    Optional<Group> group = groupService.findById(groupId);
    
    if (group.isEmpty()) {
      throw new NotFoundUserException(message.getMessage("User.not.found"));
    }
    
    return group.get();
  }
}
