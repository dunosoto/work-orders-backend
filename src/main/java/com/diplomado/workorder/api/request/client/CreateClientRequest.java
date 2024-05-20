package com.diplomado.workorder.api.request.client;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClientRequest {

  @NotNull(message = "the first name is required")
  private String firstName;
  
  @NotNull(message = "the last name is required")
  private String lastName;
  
  @NotNull(message = "the cell phone is required")
  private String telephone;
  
  @NotNull(message = "the identity card is required")
  private String identityCard;

  //contacts -> next feature.
}