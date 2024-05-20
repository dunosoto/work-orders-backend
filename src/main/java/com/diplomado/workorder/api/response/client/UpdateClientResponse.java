package com.diplomado.workorder.api.response.client;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.client.ClientDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateClientResponse extends CommonResponse {

  private ClientDto clientDto;
  
  public UpdateClientResponse(ClientDto clientDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_CODE,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG
    );
    this.clientDto = clientDto;
  }
}
