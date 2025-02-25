package com.diplomado.workorder.api.response.template;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.template.TemplateDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTemplateResponse extends CommonResponse<TemplateDto> {

  public CreateTemplateResponse(TemplateDto templateDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_STATUS,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG,
      templateDto
    );
  }
}
