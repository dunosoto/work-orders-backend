package com.diplomado.workorder.usecase.template;

import com.diplomado.workorder.api.request.template.UpdateTemplateRequest;
import com.diplomado.workorder.api.response.template.UpdateTemplateResponse;
import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.domain.template.Template;
import com.diplomado.workorder.mapper.template.TemplateMapper;
import com.diplomado.workorder.service.template.ITemplateService;
import com.diplomado.workorder.usecase.assistance.util.AssistanceValidatorUtil;
import com.diplomado.workorder.usecase.group.util.GroupValidatorUtil;
import com.diplomado.workorder.usecase.template.util.TemplateValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateTemplateUseCase {

  private ITemplateService templateService;
  private TemplateValidatorUtil templateValidatorUtil;
  private AssistanceValidatorUtil assistanceValidatorUtil;
  private GroupValidatorUtil groupValidatorUtil;
  private TemplateMapper templateMapper;
  
  
  public UpdateTemplateResponse execute(UpdateTemplateRequest request, UUID templateId) {
    Template template = templateValidatorUtil.validateTemplateId(templateId);
    Group group = groupValidatorUtil.validateGroupId(request.getGroupId());
    Assistance assistance = assistanceValidatorUtil.validateServiceId(request.getServiceId());
    
    return new UpdateTemplateResponse(
      templateMapper.templateToTemplateDto(
        this.templateService.save(buildUpdateTemplate(template, request, group, assistance))
      )
    );
  }

  private Template buildUpdateTemplate(Template template, UpdateTemplateRequest request, Group group, Assistance assistance) {
    template.setDescription((request.getDescription() == null ) ? template.getDescription() : request.getDescription());
    template.setPriority((request.getPriority() == null) ? template.getPriority() : request.getPriority());
    
    if (!template.getGroup().equals(group)) {
      template.setGroup(group);
    }

    if (!template.getAssistance().equals(assistance)) {
      template.setAssistance(assistance);
    }
    
    return template;
  }
}
