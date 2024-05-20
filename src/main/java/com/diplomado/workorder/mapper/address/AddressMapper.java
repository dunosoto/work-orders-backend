package com.diplomado.workorder.mapper.address;


import com.diplomado.workorder.api.dto.client.AddressDto;
import com.diplomado.workorder.domain.client.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
  
  AddressDto addressToAddressDto(Address address);

}