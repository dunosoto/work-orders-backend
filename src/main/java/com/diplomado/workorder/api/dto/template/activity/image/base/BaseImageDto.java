package com.diplomado.workorder.api.dto.template.activity.image.base;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BaseImageDto {
  
  private UUID id;
  private String url;
}
