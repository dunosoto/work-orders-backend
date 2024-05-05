package com.diplomado.workorder.api.response.group;


import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.group.GroupDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GroupResponse extends CommonResponse {

  private GroupDto groupDto;
  
  public GroupResponse(GroupDto groupDto) {
    super(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
    this.groupDto = groupDto;
  }
}
