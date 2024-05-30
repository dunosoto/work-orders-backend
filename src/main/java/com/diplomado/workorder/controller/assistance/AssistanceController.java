package com.diplomado.workorder.controller.assistance;

import com.diplomado.workorder.api.request.assistance.CreateAssistanceRequest;
import com.diplomado.workorder.api.response.assistance.AssistanceListResponse;
import com.diplomado.workorder.api.response.assistance.CreateAssistanceResponse;
import com.diplomado.workorder.api.response.assistance.GetAssistanceByIdResponse;
import com.diplomado.workorder.usecase.assistance.CreateAssistanceUseCase;
import com.diplomado.workorder.usecase.assistance.GetAllAssistanceUseCase;
import com.diplomado.workorder.usecase.assistance.GetAssistanceByIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("services")
@AllArgsConstructor
public class AssistanceController {
  
  private CreateAssistanceUseCase createAssistanceUseCase;
  private GetAllAssistanceUseCase getAllAssistanceUseCase;
  private GetAssistanceByIdUseCase getAssistanceByIdUseCase;
  
  @PostMapping
  public CreateAssistanceResponse create(CreateAssistanceRequest request) {
    return this.createAssistanceUseCase.execute(request);
  }
  
  @GetMapping
  public AssistanceListResponse getAll() {
    return this.getAllAssistanceUseCase.execute();
  }
  
  @GetMapping("/id")
  public GetAssistanceByIdResponse getServiceById(@Param("id") UUID serviceId) {
    return this.getAssistanceByIdUseCase.execute(serviceId);
  }
}
