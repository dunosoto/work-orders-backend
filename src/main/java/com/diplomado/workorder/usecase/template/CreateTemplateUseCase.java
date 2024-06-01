package com.diplomado.workorder.usecase.template;

import com.diplomado.workorder.api.request.template.CreateTemplateRequest;
import com.diplomado.workorder.api.response.template.CreateTemplateResponse;
import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.domain.template.Template;
import com.diplomado.workorder.mapper.template.TemplateMapper;
import com.diplomado.workorder.service.template.ITemplateService;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import com.diplomado.workorder.usecase.assistance.util.AssistanceValidatorUtil;
import com.diplomado.workorder.usecase.group.util.GroupValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTemplateUseCase implements BusinessLogicCommand<CreateTemplateResponse, CreateTemplateRequest> {
  
  private ITemplateService templateService;
  private TemplateMapper templateMapper;
  private AssistanceValidatorUtil assistanceValidatorUtil;
  private GroupValidatorUtil groupValidatorUtil;
  
  @Override
  public CreateTemplateResponse execute(CreateTemplateRequest request) {
    Assistance assistance = assistanceValidatorUtil.validateServiceId(request.getServiceId());
    Group group = groupValidatorUtil.validateGroupId(request.getGroupId());
    
    Template createTemplate = templateMapper.createTemplateRequestToTemplate(request, assistance, group);
    
    return new CreateTemplateResponse(
      templateMapper.templateToTemplateDto(templateService.save(createTemplate))
    );
  }
}
