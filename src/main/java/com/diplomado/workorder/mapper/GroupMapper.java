package com.diplomado.workorder.mapper;

import com.diplomado.workorder.api.dto.group.GroupDto;
import com.diplomado.workorder.api.request.group.CreateGroupRequest;
import com.diplomado.workorder.domain.group.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {

  Group fromCreateUserRequestToUser(CreateGroupRequest request);
  
  GroupDto fromGroupToGroupDto(Group group);
}
