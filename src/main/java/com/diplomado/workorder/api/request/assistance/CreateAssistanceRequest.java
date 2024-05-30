package com.diplomado.workorder.api.request.assistance;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateAssistanceRequest {
  
  @NotNull(message = "the addressId property is required")
  @JsonProperty("address_id")
  private UUID addressId;
  
  @NotNull(message = "the typeId property is required")
  @JsonProperty("type_id")
  private UUID typeId;
}
