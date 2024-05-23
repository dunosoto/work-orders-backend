package com.diplomado.workorder.api.request.address;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {

  @NotNull(message = "the latitude is required")
  private String latitude;

  @NotNull(message = "The longitude is required")
  private String longitude;
  
  @NotNull(message = "The location is required")
  private String location;
  
  @NotNull(message = "The city is required")
  private String city;

  @NotNull(message = "The direction is required")
  private String direction;

  @NotNull(message = "The description is required")
  private String description;
}
