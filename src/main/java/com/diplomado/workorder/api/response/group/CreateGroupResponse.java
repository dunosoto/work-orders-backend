package com.diplomado.workorder.api.response.group;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.group.GroupDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupResponse extends CommonResponse {

  private GroupDto group;
  
  public CreateGroupResponse(GroupDto group) {
    super(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, ResponseConstant.StatusCodeResponse.SUCCESS_MSG);
    this.group = group;
  }
}
