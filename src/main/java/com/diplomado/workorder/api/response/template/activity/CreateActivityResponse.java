package com.diplomado.workorder.api.response.template.activity;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.template.activity.ActivityDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateActivityResponse extends CommonResponse<ActivityDto> {
  
  public CreateActivityResponse(ActivityDto activityDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_STATUS,
      ResponseConstant.StatusCodeResponse.CREATED_SUCCESS_MSG,
      activityDto
    );
  }
}
