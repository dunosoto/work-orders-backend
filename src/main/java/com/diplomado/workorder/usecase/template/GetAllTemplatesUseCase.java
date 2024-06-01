package com.diplomado.workorder.usecase.template;

import com.diplomado.workorder.api.response.template.GetTemplateListResponse;
import com.diplomado.workorder.domain.template.Template;
import com.diplomado.workorder.mapper.template.TemplateMapper;
import com.diplomado.workorder.service.template.ITemplateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllTemplatesUseCase {

  private ITemplateService templateService;
  private TemplateMapper templateMapper;
  
  public GetTemplateListResponse execute() {
  
    List<Template> templates = templateService.getAll();
    
    return new GetTemplateListResponse(
      templates.stream().map(templateMapper::templateToTemplateDto).collect(Collectors.toList())
    );
  }
}
