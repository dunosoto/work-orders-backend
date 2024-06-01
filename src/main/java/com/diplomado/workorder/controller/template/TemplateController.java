package com.diplomado.workorder.controller.template;

import com.diplomado.workorder.api.request.template.CreateTemplateRequest;
import com.diplomado.workorder.api.request.template.UpdateTemplateRequest;
import com.diplomado.workorder.api.response.template.CreateTemplateResponse;
import com.diplomado.workorder.api.response.template.GetTemplateListResponse;
import com.diplomado.workorder.api.response.template.TemplateResponse;
import com.diplomado.workorder.api.response.template.UpdateTemplateResponse;
import com.diplomado.workorder.usecase.template.CreateTemplateUseCase;
import com.diplomado.workorder.usecase.template.GetAllTemplatesUseCase;
import com.diplomado.workorder.usecase.template.GetTemplateByIdUseCase;
import com.diplomado.workorder.usecase.template.UpdateTemplateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("work-orders")
@AllArgsConstructor
public class TemplateController {

  private CreateTemplateUseCase createTemplateUseCase;
  private GetAllTemplatesUseCase getAllTemplatesUseCase;
  private UpdateTemplateUseCase updateTemplateUseCase;
  private GetTemplateByIdUseCase getTemplateByIdUseCase;
  
  @GetMapping
  public GetTemplateListResponse getTemplateList() {
    return getAllTemplatesUseCase.execute();
  }
  
  @PostMapping
  public CreateTemplateResponse save(CreateTemplateRequest request) {
    return this.createTemplateUseCase.execute(request);
  }

  @PutMapping("/{id}")
  public UpdateTemplateResponse update(UpdateTemplateRequest request, @PathVariable("id") UUID id) {
     return  this.updateTemplateUseCase.execute(request, id);
  }
  
  @GetMapping("/{id}")
  public TemplateResponse getById(@PathVariable("id") UUID id) {
    return this.getTemplateByIdUseCase.execute(id);
  }
  
  //TODO: FALTA TABLA DE JUSTIFICACION Y LA RELACION CON LA TABLA INFORMACION TECNICA.
}
