package com.diplomado.workorder.api.response.assistance.information;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.assistance.information.TechInfoDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTechInfoResponse extends CommonResponse {

  private TechInfoDto techInfoDto;
  
  public CreateTechInfoResponse(TechInfoDto techInfoDto) {
    super(
      ResponseConstant.StatusCodeResponse.CREATED_CODE,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG
    );
    this.techInfoDto = techInfoDto;
  }
}
