package com.diplomado.workorder.usecase.group;


import com.diplomado.workorder.api.dto.group.GroupDto;
import com.diplomado.workorder.api.response.group.GroupListResponse;
import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.mapper.group.GroupMapper;
import com.diplomado.workorder.service.group.IGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllGroupsUserCase {

  private IGroupService groupService;
  private GroupMapper groupMapper;
  
  public GroupListResponse execute() {
    
    List<Group> groupList = this.groupService.getAll();
    List<GroupDto> groupDtoList = groupList.stream()
      .map(groupMapper::fromGroupToGroupDto).collect(Collectors.toList());
    
    return new GroupListResponse(groupDtoList);
  }
}
