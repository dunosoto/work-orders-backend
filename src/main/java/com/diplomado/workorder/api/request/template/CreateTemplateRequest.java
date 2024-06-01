package com.diplomado.workorder.api.request.template;

import com.diplomado.workorder.domain.template.enums.TemplatePriority;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateTemplateRequest {
  
  private UUID serviceId;
  private String description;
  private TemplatePriority priority;
  private Long groupId;
  
}
