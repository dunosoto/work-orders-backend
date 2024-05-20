package com.diplomado.workorder.api.response.client;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.client.ClientDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientListResponse extends CommonResponse {

  private List<ClientDto> clientDtoList;
  
  public ClientListResponse(List<ClientDto> clientDtolist) {
    super(
    ResponseConstant.StatusCodeResponse.SUCCESS_CODE,
    ResponseConstant.StatusCodeResponse.SUCCESS_MSG
    );
    this.clientDtoList = clientDtolist;
  }
}
