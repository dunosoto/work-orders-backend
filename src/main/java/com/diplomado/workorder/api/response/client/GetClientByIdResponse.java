package com.diplomado.workorder.api.response.client;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.client.ClientDetailDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetClientByIdResponse extends CommonResponse {
  
  private ClientDetailDto clientDetailDto;
  
  public GetClientByIdResponse(ClientDetailDto clientDetailDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_CODE,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG
    );
    this.clientDetailDto = clientDetailDto;
  }
}
