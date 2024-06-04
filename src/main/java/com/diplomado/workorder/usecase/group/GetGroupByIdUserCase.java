package com.diplomado.workorder.usecase.group;

import com.diplomado.workorder.api.response.group.GroupResponse;
import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.mapper.group.GroupMapper;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import com.diplomado.workorder.usecase.group.util.GroupValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetGroupByIdUserCase implements BusinessLogicCommand<GroupResponse, Long> {
  
  private GroupValidatorUtil groupValidatorUtil;
  private GroupMapper groupMapper;
  
  @Override
  public GroupResponse execute(Long groupId) {
    Group group = groupValidatorUtil.validateGroupId(groupId);
    
    return new GroupResponse(groupMapper.fromGroupToGroupDto(group));
  }
}
