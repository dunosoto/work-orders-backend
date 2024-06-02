package com.diplomado.workorder.api.request.template.activity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateActivityRequest {
  private String process;
  private String observations;
}
