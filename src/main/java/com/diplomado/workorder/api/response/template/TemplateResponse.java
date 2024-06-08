package com.diplomado.workorder.api.response.template;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.template.TemplateDetailDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateResponse extends CommonResponse<TemplateDetailDto> {

  public TemplateResponse(TemplateDetailDto templateDetailDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_STATUS,
      ResponseConstant.StatusCodeResponse.GET_RECORD_SUCCESS_MSG,
      templateDetailDto
    );
  }
}
