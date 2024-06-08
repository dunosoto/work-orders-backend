package com.diplomado.workorder.api.response.assistance.information;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.assistance.information.TechInfoDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTechInfoResponse extends CommonResponse<TechInfoDto> {
  
  public CreateTechInfoResponse(TechInfoDto techInfoDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_STATUS,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG,
      techInfoDto
    );
  }
}
