package com.diplomado.workorder.api.dto.user;

import com.diplomado.workorder.api.dto.role.RoleDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {
  
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Date createdAt;
  private RoleDto role;
}
