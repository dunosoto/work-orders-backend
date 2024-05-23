package com.diplomado.workorder.controller.address;

import com.diplomado.workorder.api.request.address.UpdateAddressRequest;
import com.diplomado.workorder.api.response.address.UpdateAddressResponse;
import com.diplomado.workorder.usecase.address.UpdateAddressUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("addresses")
@AllArgsConstructor
public class AddressController {

  private UpdateAddressUseCase updateAddressUseCase;
  
  @PutMapping(name = "/{uuid}")
  public UpdateAddressResponse update(UpdateAddressRequest request, @PathVariable("uuid") UUID addressId) {
    return this.updateAddressUseCase.execute(request, addressId);
  }
}
