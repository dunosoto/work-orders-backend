package com.diplomado.workorder.service.template;

import com.diplomado.workorder.domain.template.Template;
import com.diplomado.workorder.repository.template.TemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TemplateService implements ITemplateService {
  
  private TemplateRepository templateRepository;
  
  @Override
  public Template save(Template template) {
    return this.templateRepository.save(template);
  }
  
  @Override
  public List<Template> getAll() {
    return this.templateRepository.findAll();
  }
  
  @Override
  public Optional<Template> findById(UUID templateId) {
    return this.templateRepository.findById(templateId);
  }
  
  @Override
  public Template update(Template template) {
    return this.templateRepository.save(template);
  }
}
