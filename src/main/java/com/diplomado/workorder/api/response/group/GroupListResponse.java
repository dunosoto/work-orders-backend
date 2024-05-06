package com.diplomado.workorder.api.response.group;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.group.GroupDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupListResponse extends CommonResponse {

  private List<GroupDto> groups;
  
  public GroupListResponse(List<GroupDto> groupList) {
    super(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
    this.groups = groupList;
  }
  
  
}
