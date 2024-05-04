package com.diplomado.workorder.api.dto.user;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDetailDto {
  
  private Long id;
  private String firstName;
  private String lastName;
  private Integer age;
  private Date birthDay;
}
