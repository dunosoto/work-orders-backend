package com.diplomado.workorder.usecase.template.activity;

import com.diplomado.workorder.api.request.template.activity.CreateActivityRequest;
import com.diplomado.workorder.api.response.template.activity.CreateActivityResponse;
import com.diplomado.workorder.domain.template.Template;
import com.diplomado.workorder.domain.template.activity.Activity;
import com.diplomado.workorder.mapper.template.activity.ActivityMapper;
import com.diplomado.workorder.service.template.activity.IActivityService;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import com.diplomado.workorder.usecase.template.util.TemplateValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateActivityUseCase implements BusinessLogicCommand<CreateActivityResponse, CreateActivityRequest> {
  
  private IActivityService activityService;
  private ActivityMapper activityMapper;
  private TemplateValidatorUtil templateValidatorUtil;
  
  
  @Override
  public CreateActivityResponse execute(CreateActivityRequest request) {
  
    Template template = templateValidatorUtil.validateTemplateId(request.getWorkOrderId());
    Activity activity = activityMapper.createActivityRequestToActivity(request, template);
    
    return new CreateActivityResponse(
      activityMapper.activityToActivityDto(activityService.save(activity))
    );
  }
}
