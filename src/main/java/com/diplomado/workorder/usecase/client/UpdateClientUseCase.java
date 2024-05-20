package com.diplomado.workorder.usecase.client;

import com.diplomado.workorder.api.request.client.UpdateClientRequest;
import com.diplomado.workorder.api.response.client.UpdateClientResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.client.Client;
import com.diplomado.workorder.exception.client.NotFoundClientException;
import com.diplomado.workorder.mapper.client.ClientMapper;
import com.diplomado.workorder.service.client.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateClientUseCase {

  private IClientService clientService;
  private ClientMapper clientMapper;
  private Message message;

  public UpdateClientResponse execute(UpdateClientRequest request, UUID clientId) {
    Client client = this.validateClientId(clientId);
    Client updateClient = this.buildUpdateClient(request, client);
    
    return new UpdateClientResponse(
      this.clientMapper.clientToClientDto(this.clientService.save(updateClient))
    );
  }

  private Client validateClientId(UUID clientId) {
    Optional<Client> client = clientService.findById(clientId);
    
    if (client.isEmpty()) throw new NotFoundClientException(message.getMessage("Client.not.found"));
    
    return  client.get();
  }

  private Client buildUpdateClient(UpdateClientRequest request, Client client) {
    client.setFirstName((request.getFirstName() == null) ? request.getFirstName() : client.getFirstName());
    client.setLastName((request.getLastName() == null) ? request.getLastName() : client.getLastName());
    client.setTelephone((request.getTelephone() == null) ? request.getTelephone() : client.getTelephone());
    client.setIdentityCard((request.getIdentityCard() == null) ? request.getIdentityCard() : client.getIdentityCard());
    
    return client;
  }
}
