package com.diplomado.workorder.usecase.address;

import com.diplomado.workorder.api.request.address.CreateAddressRequest;
import com.diplomado.workorder.api.response.address.CreateAddressResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.client.Address;
import com.diplomado.workorder.domain.client.Client;
import com.diplomado.workorder.exception.client.NotFoundClientException;
import com.diplomado.workorder.mapper.address.AddressMapper;
import com.diplomado.workorder.service.address.IAddressService;
import com.diplomado.workorder.service.client.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreateAddressUseCase {

  private AddressMapper addressMapper;
  private IAddressService addressService;
  private IClientService clientService;
  private Message message;
  
  public CreateAddressResponse execute(CreateAddressRequest request, UUID clientId) {

    Client client = this.validateClientId(clientId);
  
    Address createdAddress = this.addressService.save(addressMapper.createAddressRequestToAddress(request, client));
    
    return new CreateAddressResponse(
      addressMapper.addressToAddressDto(createdAddress)
    );
  }
  
  private Client validateClientId(UUID clientId) {
    Optional<Client> client = clientService.findById(clientId);
    
    if (client.isEmpty()) throw new NotFoundClientException(message.getMessage("Client.not.found"));
    
    return  client.get();
  }
}
