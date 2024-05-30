package com.diplomado.workorder.api.response.assistance;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.assistance.AssistanceDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAssistanceResponse extends CommonResponse {

  private AssistanceDto assistanceDto;
  
  public CreateAssistanceResponse(AssistanceDto assistanceDto) {
    super(
      ResponseConstant.StatusCodeResponse.CREATED_CODE,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG
    );
    this.assistanceDto = assistanceDto;
  }
}
