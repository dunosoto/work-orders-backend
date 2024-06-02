package com.diplomado.workorder.api.request.template.activity;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateActivityRequest {

  @NotNull
  private UUID workOrderId;

  @NotNull
  private String process;

  private String observations;
}
