package com.diplomado.workorder.mapper.template;

import com.diplomado.workorder.api.dto.assistance.AssistanceDto;
import com.diplomado.workorder.api.dto.group.GroupDto;
import com.diplomado.workorder.api.dto.template.TemplateDetailDto;
import com.diplomado.workorder.api.dto.template.TemplateDto;
import com.diplomado.workorder.api.request.template.CreateTemplateRequest;
import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.domain.template.Template;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TemplateMapper {
  
  @Mapping(target = "Template.assistance", source = "java(assistance)")
  @Mapping(target = "Template.group", source = "java(group)")
  Template createTemplateRequestToTemplate(CreateTemplateRequest request, Assistance assistance, Group group);
  
  @Mapping(target = "TemplateDto.group.id", source = "java(template.getGroup().getId())")
  @Mapping(target = "TemplateDto.group.prefix", source = "java(template.getGroup().getPrefix())")
  TemplateDto templateToTemplateDto(Template template);
  

  //WITH THE OTHER FUNCTION IT SHOULD WORKS.
  TemplateDetailDto templateToTemplateDetailDto(Template template);
  GroupDto groupToGroupDto(Group group);
  AssistanceDto assistanceToAssistanceDto(Assistance assistance);
  
}
