package com.diplomado.workorder.usecase.group;

import com.diplomado.workorder.api.request.group.CreateGroupRequest;
import com.diplomado.workorder.api.response.group.CreateGroupResponse;
import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.domain.user.User;
import com.diplomado.workorder.domain.user.UserGroup;
import com.diplomado.workorder.mapper.group.GroupMapper;
import com.diplomado.workorder.service.group.IGroupService;
import com.diplomado.workorder.service.user.usergroup.IUserGroupService;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import com.diplomado.workorder.usecase.user.util.UserValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CreateGroupUseCase implements BusinessLogicCommand<CreateGroupResponse, CreateGroupRequest> {
  
  private IGroupService groupService;
  private UserValidatorUtil userValidatorUtil;
  private IUserGroupService memberService;
  private GroupMapper groupMapper;
  
  @Override
  public CreateGroupResponse execute(CreateGroupRequest request) {
    
    Group group = groupService.save(groupMapper.fromCreateUserRequestToUser(request));

    if (!request.getMembers().isEmpty()) {
      List<User> userList = validateUserIds(request.getMembers());
      saveMembersToGroup(userList, group);
    }
    
    return new CreateGroupResponse(groupMapper.fromGroupToGroupDto(group));
  }

  private List<User> validateUserIds(List<Long> userIds) {
    return userIds.stream().map(userValidatorUtil::validateUserId).collect(Collectors.toList());
  }

  private void saveMembersToGroup(List<User> userList, Group group) {
    List<UserGroup> members = new ArrayList<>();
    
    userList.forEach(user -> members.add(buildUserGroup(group, user)));
    
    memberService.saveAll(members);
  }
  
  private UserGroup buildUserGroup(Group group, User user) {
    UserGroup member = new UserGroup();
    member.setGroup(group);
    member.setUser(user);
    
    return member;
  }
}
