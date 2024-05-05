package com.diplomado.workorder.api.request.group;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateGroupRequest {

  @NotNull(message = "The group prefix is required")
  private String prefix;
  
  private List<Long> members;
}
