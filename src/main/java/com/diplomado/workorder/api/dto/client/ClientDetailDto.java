package com.diplomado.workorder.api.dto.client;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientDetailDto extends ClientDto {

  private List<AddressDto> addressDtoList;
  
}
