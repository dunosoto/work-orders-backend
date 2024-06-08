package com.diplomado.workorder.api.response.assistance;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.assistance.AssistanceDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAssistanceByIdResponse extends CommonResponse<AssistanceDto> {

  public GetAssistanceByIdResponse(AssistanceDto assistanceDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_STATUS,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG,
      assistanceDto
    );
  }
}
