package com.diplomado.workorder.usecase.client;

import com.diplomado.workorder.api.dto.address.AddressDto;
import com.diplomado.workorder.api.response.client.GetClientByIdResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.client.Address;
import com.diplomado.workorder.domain.client.Client;
import com.diplomado.workorder.exception.client.NotFoundClientException;
import com.diplomado.workorder.mapper.address.AddressMapper;
import com.diplomado.workorder.mapper.client.ClientMapper;
import com.diplomado.workorder.service.client.IClientService;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetClientByIdUseCase implements BusinessLogicCommand<GetClientByIdResponse, UUID> {

  private IClientService clientService;
  private ClientMapper clientMapper;
  private AddressMapper addressMapper;
  private Message message;

  @Override
  public GetClientByIdResponse execute(UUID clientId) {
    Client client = this.validateClientId(clientId);
    
    return new GetClientByIdResponse(
      clientMapper.clientToClientDetailDto(client, this.mapAddressList(client.getAddresses()))
    );
  }
  
  private Client validateClientId(UUID clientId) {
    Optional<Client> client = clientService.findById(clientId);
    
    if (client.isEmpty()) throw new NotFoundClientException(message.getMessage("Client.not.found"));
    
    return  client.get();
  }
  
  private List<AddressDto> mapAddressList(List<Address> addresses) {
    return addresses.stream().map(addressMapper::addressToAddressDto).collect(Collectors.toList());
  }
  
}
