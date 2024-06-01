package com.diplomado.workorder.usecase.template.util;

import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.template.Template;
import com.diplomado.workorder.exception.template.NotFoundTemplateException;
import com.diplomado.workorder.service.template.ITemplateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TemplateValidatorUtil {
  
  private ITemplateService templateService;
  private Message message;
  
  public Template validateTemplateId(UUID templateId) {
    Optional<Template> templateOptional = templateService.findById(templateId);
    
    if (templateOptional.isEmpty()) {
      throw new NotFoundTemplateException(message.getMessage("Template.not.found"));
    }

    return templateOptional.get();
  }
}
