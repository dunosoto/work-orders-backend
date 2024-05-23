package com.diplomado.workorder.service.address;

import com.diplomado.workorder.domain.client.Address;
import com.diplomado.workorder.repository.address.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressService implements IAddressService {
  
  private AddressRepository addressRepository;
  
  @Override
  public Address save(Address address) {
    return addressRepository.save(address);
  }
  
  @Override
  public List<Address> getAll() {
    return addressRepository.findAll();
  }
  
  @Override
  public Optional<Address> findById(UUID uuid) {
    return addressRepository.findById(uuid);
  }
  
  @Override
  public Address update(Address address) {
    return addressRepository.save(address);
  }
}
