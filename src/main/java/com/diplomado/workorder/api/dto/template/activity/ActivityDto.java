package com.diplomado.workorder.api.dto.template.activity;

import com.diplomado.workorder.api.dto.template.activity.base.BaseActivityDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ActivityDto extends BaseActivityDto {
  
  private UUID workOrderId;
}
