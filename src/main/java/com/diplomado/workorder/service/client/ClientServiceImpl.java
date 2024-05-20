package com.diplomado.workorder.service.client;

import com.diplomado.workorder.domain.client.Client;
import com.diplomado.workorder.repository.client.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {
  
  private ClientRepository clientRepository;
  
  @Override
  public Client save(Client client) {
    return clientRepository.save(client);
  }
  
  @Override
  public List<Client> getAll() {
    return clientRepository.findAll();
  }
  
  @Override
  public Optional<Client> findById(UUID id) {
    return clientRepository.findById(id);
  }
  
  @Override
  public Client update(Client client) {
    return clientRepository.save(client);
  }
}
