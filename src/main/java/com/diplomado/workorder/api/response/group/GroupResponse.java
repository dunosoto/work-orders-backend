package com.diplomado.workorder.api.response.group;


import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.group.GroupDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GroupResponse extends CommonResponse<GroupDto> {
  
  public GroupResponse(GroupDto groupDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_STATUS,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG,
      groupDto
    );
  }
}
