package com.diplomado.workorder.api.response.client;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.client.ClientDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClientResponse extends CommonResponse {

  private ClientDto clientDto;
  
  public CreateClientResponse(ClientDto clientDto) {
    super(
      ResponseConstant.StatusCodeResponse.CREATED_CODE,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG
    );
    this.clientDto = clientDto;
  }
}
