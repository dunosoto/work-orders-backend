package com.diplomado.workorder.mapper.template.activity;

import com.diplomado.workorder.api.dto.template.activity.ActivityDto;
import com.diplomado.workorder.api.request.template.activity.CreateActivityRequest;
import com.diplomado.workorder.domain.template.Template;
import com.diplomado.workorder.domain.template.activity.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

  @Mapping(target = "workOrderId", source = "activity.workOrder.id")
  ActivityDto activityToActivityDto(Activity activity);
  
  @Mapping(target = "workOrder", source = "java(template)")
  Activity createActivityRequestToActivity(CreateActivityRequest request, Template template);

}
