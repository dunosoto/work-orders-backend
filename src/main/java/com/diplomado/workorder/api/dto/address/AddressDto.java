package com.diplomado.workorder.api.dto.address;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddressDto {
  
  private UUID id;
  private String latitude;
  private String longitude;
  private String location;
  private String city;
  private boolean actived;
  private String direction;
  private String description;
}
