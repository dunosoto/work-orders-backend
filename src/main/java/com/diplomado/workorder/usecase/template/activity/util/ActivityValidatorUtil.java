package com.diplomado.workorder.usecase.template.activity.util;

import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.template.activity.Activity;
import com.diplomado.workorder.exception.template.activity.NotFoundAcitvityException;
import com.diplomado.workorder.service.template.activity.IActivityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ActivityValidatorUtil {

  private IActivityService activityService;
  private Message message;

  public Activity valdaiteActivityId(UUID id) {
  
    Optional<Activity> activity = activityService.findById(id);
    
    if(activity.isEmpty()) {
      throw new NotFoundAcitvityException(message.getMessage("Activity.not.found"));
    }
    
    return  activity.get();
  }
}
