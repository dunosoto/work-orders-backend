package com.diplomado.workorder.api.dto.template.activity.base;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BaseActivityDto {

  private UUID id;
  private String process;
  private String observation;

}
