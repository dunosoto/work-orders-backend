package com.diplomado.workorder.api.response.assistance;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.assistance.AssistanceDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AssistanceListResponse extends CommonResponse {
  
  private List<AssistanceDto> assistanceDtoList;
  
  public AssistanceListResponse(List<AssistanceDto> assistanceDtoList) {
    super(
    ResponseConstant.StatusCodeResponse.SUCCESS_CODE,
    ResponseConstant.StatusCodeResponse.SUCCESS_MSG
    );
    this.assistanceDtoList = assistanceDtoList;
  }
}
