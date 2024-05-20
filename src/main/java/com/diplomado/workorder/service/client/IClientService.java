package com.diplomado.workorder.service.client;

import com.diplomado.workorder.domain.client.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IClientService {
  
  Client save(Client Client);
  List<Client> getAll();
  Optional<Client> findById(UUID id);
  Client update(Client Client);
}
