package com.diplomado.workorder.api.dto.template.activity;

import com.diplomado.workorder.domain.template.activity.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ActivityDetailDto {
  private List<Image> images;
}
