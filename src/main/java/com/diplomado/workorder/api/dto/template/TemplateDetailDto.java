package com.diplomado.workorder.api.dto.template;

import com.diplomado.workorder.api.dto.assistance.AssistanceDto;
import com.diplomado.workorder.api.dto.group.GroupDto;
import com.diplomado.workorder.api.dto.template.base.BaseTemplateDto;
import com.diplomado.workorder.domain.template.activity.Activity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateDetailDto extends BaseTemplateDto {

  private Activity activity;
  private GroupDto group;
  private AssistanceDto assistance;
}
