package com.diplomado.workorder.api.request.client;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateClientRequest {

  @NotEmpty
  private String firstName;
  
  private String lastName;
  
  private String telephone;
  
  private String identityCard;
}
