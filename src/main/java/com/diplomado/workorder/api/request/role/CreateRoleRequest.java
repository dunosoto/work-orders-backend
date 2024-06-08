package com.diplomado.workorder.api.request.role;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoleRequest {
  private String name;

  @NotNull(message = "the prefix property is required")
  private String prefix;
}
