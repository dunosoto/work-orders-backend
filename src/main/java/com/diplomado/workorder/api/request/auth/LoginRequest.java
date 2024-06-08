package com.diplomado.workorder.api.request.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

  @NotNull
  private String email;
  
  @NotNull
  private String password;
}
