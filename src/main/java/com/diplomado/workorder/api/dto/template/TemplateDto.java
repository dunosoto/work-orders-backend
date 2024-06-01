package com.diplomado.workorder.api.dto.template;

import com.diplomado.workorder.api.dto.group.BaseGroupDto;
import com.diplomado.workorder.api.dto.template.base.BaseTemplateDto;
import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.domain.template.activity.Activity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateDto extends BaseTemplateDto {
  
  private Activity activity;
  private BaseGroupDto group;
  private Assistance assistance;
}
