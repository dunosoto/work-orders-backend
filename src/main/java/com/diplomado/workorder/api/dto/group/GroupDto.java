package com.diplomado.workorder.api.dto.group;

import com.diplomado.workorder.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupDto {
  
  private Long id;
  private String prefix;
  private List<User> members;
}
