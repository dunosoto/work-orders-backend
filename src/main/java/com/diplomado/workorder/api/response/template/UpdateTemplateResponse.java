package com.diplomado.workorder.api.response.template;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.template.TemplateDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTemplateResponse extends CommonResponse {

  private TemplateDto templateDto;
  
  public UpdateTemplateResponse(TemplateDto templateDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_CODE,
      ResponseConstant.StatusCodeResponse.UPDATED_SUCCESS_MSG
    );
    this.templateDto = templateDto;
  }
}
