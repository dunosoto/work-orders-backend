package com.diplomado.workorder.controller.template.activity;

import com.diplomado.workorder.api.request.template.activity.CreateActivityRequest;
import com.diplomado.workorder.api.request.template.activity.UpdateActivityRequest;
import com.diplomado.workorder.api.request.template.activity.image.CreateImageRequest;
import com.diplomado.workorder.api.response.template.activity.CreateActivityResponse;
import com.diplomado.workorder.api.response.template.activity.UpdateActivityResponse;
import com.diplomado.workorder.api.response.template.activity.image.CreateImageResponse;
import com.diplomado.workorder.usecase.template.activity.CreateActivityUseCase;
import com.diplomado.workorder.usecase.template.activity.UpdateActivityUseCase;
import com.diplomado.workorder.usecase.template.activity.image.CreateImageUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("work-orders/activities")
@AllArgsConstructor
public class ActivityController {

  private CreateActivityUseCase createActivityUseCase;
  private UpdateActivityUseCase updateActivityUseCase;
  private CreateImageUseCase createImageUseCase;
  
  @PostMapping
  public CreateActivityResponse save(CreateActivityRequest request) {
    return createActivityUseCase.execute(request);
  }

  @PutMapping("/{id}")
  public UpdateActivityResponse update(UpdateActivityRequest request, @PathVariable("id") UUID id) {
    return updateActivityUseCase.execute(request, id);
  }

  @PostMapping("/images")
  public CreateImageResponse saveImage(CreateImageRequest request) {
    return createImageUseCase.execute(request);
  }
}
