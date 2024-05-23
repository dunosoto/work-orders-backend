package com.diplomado.workorder.api.request.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAddressRequest {
  private String latitude;
  private String longitude;
  private String location;
  private String city;
  private String direction;
  private String description;
}
