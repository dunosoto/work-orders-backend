package com.diplomado.workorder.controller.group;

import com.diplomado.workorder.api.request.group.CreateGroupRequest;
import com.diplomado.workorder.api.response.group.CreateGroupResponse;
import com.diplomado.workorder.api.response.group.GroupListResponse;
import com.diplomado.workorder.api.response.group.GroupResponse;
import com.diplomado.workorder.usecase.group.CreateGroupUseCase;
import com.diplomado.workorder.usecase.group.GetAllGroupsUserCase;
import com.diplomado.workorder.usecase.group.GetGroupByIdUserCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("groups")
@AllArgsConstructor
public class GroupController {

  private CreateGroupUseCase createGroupUseCase;
  private GetAllGroupsUserCase getAllGroupsUserCase;
  private GetGroupByIdUserCase getGroupByIdUserCase;
  
  @PostMapping
  public CreateGroupResponse saveGroup(@RequestBody @Valid CreateGroupRequest request) {
    return this.createGroupUseCase.execute(request);
  }
  
  @GetMapping
  public GroupListResponse getGroupList() {
    return getAllGroupsUserCase.execute();
  }
  
  @GetMapping("/{id}")
  public GroupResponse getGroupById(@PathVariable("id") Long groupId) {
    return getGroupByIdUserCase.execute(groupId);
  }
  
}
