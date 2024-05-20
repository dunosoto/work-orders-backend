package com.diplomado.workorder.usecase.client;

import com.diplomado.workorder.api.request.client.CreateClientRequest;
import com.diplomado.workorder.api.response.client.CreateClientResponse;
import com.diplomado.workorder.domain.client.Client;
import com.diplomado.workorder.mapper.client.ClientMapper;
import com.diplomado.workorder.service.client.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientUseCase {

  private ClientMapper clientMapper;
  private IClientService clientService;
  
  public CreateClientResponse execute(CreateClientRequest request) {
  
    Client client = clientService.save(clientMapper.createClientRequestToClient(request));
    
    return new CreateClientResponse(
      clientMapper.clientToClientDto(client)
    );
  }
}
