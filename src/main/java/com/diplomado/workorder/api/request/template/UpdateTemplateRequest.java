package com.diplomado.workorder.api.request.template;

import com.diplomado.workorder.domain.template.enums.TemplatePriority;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class UpdateTemplateRequest {
  
  @NotNull
  private UUID serviceId;
  private String description;
  private TemplatePriority priority;
  private Date start;
  private Date finish;
  @NotNull
  private Long groupId;

}
