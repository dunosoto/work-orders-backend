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
  
  @Mapping(target = "Template.assistance", expression = "java(assistance)")
  @Mapping(target = "Template.group", expression = "java(group)")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  Template createTemplateRequestToTemplate(CreateTemplateRequest request, Assistance assistance, Group group);
  
  @Mapping(target = "TemplateDto.group.id", expression = "java(template.getGroup().getId())")
  @Mapping(target = "TemplateDto.group.prefix", expression = "java(template.getGroup().getPrefix())")
  TemplateDto templateToTemplateDto(Template template);
  

  //WITH THE OTHER FUNCTION IT SHOULD WORKS.
  TemplateDetailDto templateToTemplateDetailDto(Template template);
  GroupDto groupToGroupDto(Group group);
  AssistanceDto assistanceToAssistanceDto(Assistance assistance);
  
}