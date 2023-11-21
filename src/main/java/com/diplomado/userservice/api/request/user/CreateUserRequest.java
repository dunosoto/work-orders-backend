package com.diplomado.userservice.api.request.user;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CreateUserRequest {
  
  private String userName;
  private String password;
  private String email;
  private Date createdAt;
  
  private String firstName;
  private String lastName;
  private Integer age;
  private Date birthDay;
  
  private List<Long> roleIds;

}
