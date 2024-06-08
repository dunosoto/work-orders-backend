package com.diplomado.workorder.mapper.group;

import com.diplomado.workorder.api.dto.group.GroupDto;
import com.diplomado.workorder.api.request.group.CreateGroupRequest;
import com.diplomado.workorder.domain.group.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {

  @Mapping(target = "members", ignore = true)
  Group fromCreateUserRequestToUser(CreateGroupRequest request);
  
  GroupDto fromGroupToGroupDto(Group group);
}
