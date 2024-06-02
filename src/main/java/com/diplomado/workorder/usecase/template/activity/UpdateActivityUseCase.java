package com.diplomado.workorder.usecase.template.activity;

import com.diplomado.workorder.api.request.template.activity.UpdateActivityRequest;
import com.diplomado.workorder.api.response.template.activity.UpdateActivityResponse;
import com.diplomado.workorder.domain.template.activity.Activity;
import com.diplomado.workorder.mapper.template.activity.ActivityMapper;
import com.diplomado.workorder.usecase.template.activity.util.ActivityValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateActivityUseCase {

  private ActivityValidatorUtil activityValidatorUtil;
  private ActivityMapper activityMapper;
  
  public UpdateActivityResponse execute(UpdateActivityRequest request, UUID id) {
  
    Activity activity = activityValidatorUtil.valdaiteActivityId(id);
    
    return new UpdateActivityResponse(
      activityMapper.activityToActivityDto(buildUpdateActivity(request, activity))
    );
  }
  
  private Activity buildUpdateActivity(UpdateActivityRequest request, Activity activity) {

    activity.setProcess((request.getProcess() == null) ? activity.getProcess() : request.getProcess());
    activity.setProcess((request.getObservations() == null) ? activity.getObservation() : request.getObservations());

    return  activity;
  }
}
