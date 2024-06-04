package com.diplomado.workorder.api.request.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateUserRequest {

  @NotNull
  private String firstName;
  @NotNull
  private String lastName;

  @NotNull
  @Email(message = "Please provide a valid email address")
  private String email;

  @NotNull
  @Min(8)
  private String password;

  @NotNull
  private Long roleId;

  //TODO: IMPROVEMENT.
  private List<Long> groupIds;
}
