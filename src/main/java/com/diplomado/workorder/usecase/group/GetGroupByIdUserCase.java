package com.diplomado.workorder.usecase.group;

import com.diplomado.workorder.api.response.group.GroupResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.exception.user.NotFoundUserException;
import com.diplomado.workorder.mapper.GroupMapper;
import com.diplomado.workorder.service.group.IGroupService;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetGroupByIdUserCase implements BusinessLogicCommand<GroupResponse, Long> {
  
  private IGroupService groupService;
  private GroupMapper groupMapper;
  private Message message;
  
  @Override
  public GroupResponse execute(Long groupId) {
    Group group = validateGroupId(groupId);
    
    return new GroupResponse(groupMapper.fromGroupToGroupDto(group));
  }
  
  private Group validateGroupId(Long groupId) {
    Optional<Group> group = groupService.findById(groupId);
    
    if (group.isEmpty()) {
      throw new NotFoundUserException(message.getMessage("User.not.found"));
    }
    
    return group.get();
  }
}
