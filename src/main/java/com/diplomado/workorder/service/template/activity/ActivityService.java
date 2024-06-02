package com.diplomado.workorder.service.template.activity;

import com.diplomado.workorder.domain.template.activity.Activity;
import com.diplomado.workorder.repository.template.activity.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ActivityService implements IActivityService {
  
  private ActivityRepository activityRepository;
  
  @Override
  public Activity save(Activity activity) {
    return activityRepository.save(activity);
  }
  
  @Override
  public List<Activity> getAll() {
    return null;
  }
  
  @Override
  public Optional<Activity> findById(UUID uuid) {
    return activityRepository.findById(uuid);
  }
  
  @Override
  public Activity update(Activity activity) {
    return activityRepository.save(activity);
  }
}
