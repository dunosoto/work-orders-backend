package com.diplomado.workorder.api.request.template.activity.image;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateImageRequest {

  private UUID activityId;
  private String url;
}
