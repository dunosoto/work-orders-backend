package com.diplomado.workorder.api.dto.group;

import com.diplomado.workorder.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupDto extends BaseGroupDto {
  
  private List<User> members;
}
