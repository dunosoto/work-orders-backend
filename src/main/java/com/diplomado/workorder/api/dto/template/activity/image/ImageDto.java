package com.diplomado.workorder.api.dto.template.activity.image;


import com.diplomado.workorder.api.dto.template.activity.image.base.BaseImageDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ImageDto extends BaseImageDto {
  
  private UUID activityId;
}
