package com.diplomado.workorder.api.response.address;


import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.address.AddressDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressResponse extends CommonResponse {
  
  private AddressDto addressDto;
  
  public CreateAddressResponse(AddressDto addressDto) {
    super(
    ResponseConstant.StatusCodeResponse.CREATED_CODE,
    ResponseConstant.StatusCodeResponse.SUCCESS_MSG
    );
    this.addressDto = addressDto;
  }
}
