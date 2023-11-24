package com.diplomado.userservice.api.request.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CreateUserRequest {
  
  @NotNull(message = "the user name is required")
  private String userName;
  
  @NotNull
  private String password;

  @NotNull
  @Email(message = "Please provide a valid email address")
  private String email;

  private Date createdAt;
  
  private String firstName;
  private String lastName;
  private Integer age;
  private Date birthDay;
  
  @NotNull
  private List<Long> roleIds;

}
