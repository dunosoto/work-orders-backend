package com.diplomado.workorder.api.dto.template.base;

import com.diplomado.workorder.domain.template.enums.TemplatePriority;
import com.diplomado.workorder.domain.template.enums.TemplateStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BaseTemplateDto {
  
  private UUID id;
  private String description;
  private TemplateStatus status;
  private TemplatePriority priority;
  private Date start;
  private Date finish;
  private Instant createdAt;
  private Date updatedAt;
}
