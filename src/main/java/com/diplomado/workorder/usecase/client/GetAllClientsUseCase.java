package com.diplomado.workorder.usecase.client;

import com.diplomado.workorder.api.dto.client.ClientDto;
import com.diplomado.workorder.api.response.client.ClientListResponse;
import com.diplomado.workorder.domain.client.Client;
import com.diplomado.workorder.mapper.client.ClientMapper;
import com.diplomado.workorder.service.client.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllClientsUseCase {

  private IClientService clientService;
  private ClientMapper clientMapper;
  
  public ClientListResponse execute() {
  
    List<Client> clientList = this.clientService.getAll();
    List<ClientDto> clientDtos = clientList.stream().map(this.clientMapper::clientToClientDto)
      .collect(Collectors.toList());

    return new ClientListResponse(clientDtos);
  }
  
}
