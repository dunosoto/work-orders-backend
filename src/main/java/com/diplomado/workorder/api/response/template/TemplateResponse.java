package com.diplomado.workorder.api.response.template;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.template.TemplateDetailDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateResponse extends CommonResponse {

  private TemplateDetailDto templateDetailDto;
  
  public TemplateResponse(TemplateDetailDto templateDetailDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_CODE,
      ResponseConstant.StatusCodeResponse.GET_RECORD_SUCCESS_MSG
    );
    this.templateDetailDto = templateDetailDto;
  }
}
