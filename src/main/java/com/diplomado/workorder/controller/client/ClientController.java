package com.diplomado.workorder.controller.client;

import com.diplomado.workorder.api.request.address.CreateAddressRequest;
import com.diplomado.workorder.api.request.client.CreateClientRequest;
import com.diplomado.workorder.api.request.client.UpdateClientRequest;
import com.diplomado.workorder.api.response.client.ClientListResponse;
import com.diplomado.workorder.api.response.client.CreateClientResponse;
import com.diplomado.workorder.api.response.client.GetClientByIdResponse;
import com.diplomado.workorder.api.response.client.UpdateClientResponse;
import com.diplomado.workorder.usecase.client.CreateClientUseCase;
import com.diplomado.workorder.usecase.client.GetAllClientsUseCase;
import com.diplomado.workorder.usecase.client.GetClientByIdUseCase;
import com.diplomado.workorder.usecase.client.UpdateClientUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {

  private CreateClientUseCase createClientUseCase;
  private GetAllClientsUseCase getAllClientsUseCase;
  private UpdateClientUseCase updateClientUseCase;
  private GetClientByIdUseCase getClientByIdUseCase;
  
  @PostMapping
  public CreateClientResponse saveClient(@RequestBody @Valid CreateClientRequest request) {
    return this.createClientUseCase.execute(request);
  }
  
  @GetMapping
  public ClientListResponse getClientList() {
    return this.getAllClientsUseCase.execute();
  }
  
  @GetMapping("/{id}")
  public GetClientByIdResponse getClientById(@PathVariable("id") UUID clientId) {
    return this.getClientByIdUseCase.execute(clientId);
  }
  
  @PutMapping("/{id}")
  public UpdateClientResponse updateClient(@RequestBody @Valid UpdateClientRequest request, @PathVariable("id") UUID clientId) {
    return this.updateClientUseCase.execute(request, clientId);
  }

  @DeleteMapping("/{id}")
  public void deleteClient(@PathVariable("id") UUID clientId) {}

  //save a new address to client.
  @PostMapping("/{uuid}/address")
  public void saveAddress(@RequestBody @Valid CreateAddressRequest request, @PathVariable("uuid") UUID clientId ) {
  
  }
  
}
