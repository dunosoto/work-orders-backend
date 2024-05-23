package com.diplomado.workorder.mapper.address;


import com.diplomado.workorder.api.dto.address.AddressDto;
import com.diplomado.workorder.api.request.address.CreateAddressRequest;
import com.diplomado.workorder.domain.client.Address;
import com.diplomado.workorder.domain.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
  
  AddressDto addressToAddressDto(Address address);
  
  @Mapping(target = "Address.client", source = "java(client)")
  Address createAddressRequestToAddress(CreateAddressRequest request, Client client);

}