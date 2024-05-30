package com.diplomado.workorder.controller.assistance.information;

import com.diplomado.workorder.api.request.assistance.information.CreateTechInfoRequest;
import com.diplomado.workorder.api.response.assistance.information.CreateTechInfoResponse;
import com.diplomado.workorder.usecase.assistance.information.CreateTechInfoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("technicals-information")
@AllArgsConstructor
public class TechnicalInformationController {

  private CreateTechInfoUseCase createTechInfoUseCase;

  @PostMapping
  public CreateTechInfoResponse save(CreateTechInfoRequest request) {
    return this.createTechInfoUseCase.execute(request);
  }
  
}
