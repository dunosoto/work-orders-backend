package com.diplomado.workorder.api.response.address;


import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.address.AddressDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressResponse extends CommonResponse<AddressDto> {
  
  public CreateAddressResponse(AddressDto addressDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_STATUS,
      ResponseConstant.StatusCodeResponse.SUCCESS_MSG,
      addressDto
    );
  }
}
