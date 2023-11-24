package com.diplomado.userservice.api.request.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserNameRequest {
  
  @NotNull(message = "the user name is required")
  private String userName;
}
