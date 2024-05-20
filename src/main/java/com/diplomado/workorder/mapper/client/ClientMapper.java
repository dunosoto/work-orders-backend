package com.diplomado.workorder.mapper.client;

import com.diplomado.workorder.api.dto.client.AddressDto;
import com.diplomado.workorder.api.dto.client.ClientDetailDto;
import com.diplomado.workorder.api.dto.client.ClientDto;
import com.diplomado.workorder.api.request.client.CreateClientRequest;
import com.diplomado.workorder.domain.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  Client createClientRequestToClient(CreateClientRequest request);
  
  ClientDto clientToClientDto(Client client);
  
  @Mapping(target = "addressDtoList", expression = "java(addressDtoList)")
  ClientDetailDto clientToClientDetailDto(Client client, List<AddressDto> addressDtoList);
}
