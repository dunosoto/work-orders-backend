package com.diplomado.workorder.api.response.template;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.template.TemplateDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetTemplateListResponse extends CommonResponse {

  private List<TemplateDto> templateDtoList;
  
  public GetTemplateListResponse(List<TemplateDto> templateDtoList) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_CODE,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG
    );
    this.templateDtoList = templateDtoList;
  }
}
