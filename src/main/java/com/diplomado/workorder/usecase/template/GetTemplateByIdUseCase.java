package com.diplomado.workorder.usecase.template;

import com.diplomado.workorder.api.response.template.TemplateResponse;
import com.diplomado.workorder.domain.template.Template;
import com.diplomado.workorder.mapper.template.TemplateMapper;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import com.diplomado.workorder.usecase.template.util.TemplateValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GetTemplateByIdUseCase implements BusinessLogicCommand<TemplateResponse, UUID> {
  
  private TemplateValidatorUtil templateValidatorUtil;
  private TemplateMapper templateMapper;
  
  @Override
  public TemplateResponse execute(UUID id) {
  
    Template template = templateValidatorUtil.validateTemplateId(id);
    
    return new TemplateResponse(
      this.templateMapper.templateToTemplateDetailDto(template)
    );
  }
}

