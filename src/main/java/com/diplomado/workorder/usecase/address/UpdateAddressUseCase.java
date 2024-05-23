package com.diplomado.workorder.usecase.address;

import com.diplomado.workorder.api.request.address.UpdateAddressRequest;
import com.diplomado.workorder.api.response.address.UpdateAddressResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.client.Address;
import com.diplomado.workorder.exception.address.NotFoundAddressException;
import com.diplomado.workorder.mapper.address.AddressMapper;
import com.diplomado.workorder.service.address.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateAddressUseCase {
  
  private IAddressService addressService;
  private AddressMapper addressMapper;
  private Message message;
  
  public UpdateAddressResponse execute(UpdateAddressRequest request, UUID addressId) {
    Address address = this.validateAddressId(addressId);
    
    Address updateAddress = this.buildUpdateAddress(request, address);
    
    return new UpdateAddressResponse(
      addressMapper.addressToAddressDto(addressService.save(updateAddress))
    );
  }

  private Address validateAddressId(UUID addressId) {
    Optional<Address> optionalAddress = this.addressService.findById(addressId);
    
    if (optionalAddress.isEmpty()) {
      throw new NotFoundAddressException(message.getMessage("Address.not.found"));
    }
    
    return optionalAddress.get();
  }
  
  private Address buildUpdateAddress(UpdateAddressRequest request, Address address) {
 
    address.setLatitude(request.getLatitude());
    address.setLongitude(request.getLongitude());
    address.setCity(request.getCity());
    address.setCity(request.getCity());

    return address;
  }
}
