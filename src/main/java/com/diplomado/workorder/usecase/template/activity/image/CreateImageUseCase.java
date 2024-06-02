package com.diplomado.workorder.usecase.template.activity.image;

import com.diplomado.workorder.api.request.template.activity.image.CreateImageRequest;
import com.diplomado.workorder.api.response.template.activity.image.CreateImageResponse;
import com.diplomado.workorder.domain.template.activity.Activity;
import com.diplomado.workorder.domain.template.activity.Image;
import com.diplomado.workorder.mapper.template.activity.image.ImageMapper;
import com.diplomado.workorder.service.template.activity.image.IImageService;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import com.diplomado.workorder.usecase.template.activity.util.ActivityValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateImageUseCase implements BusinessLogicCommand<CreateImageResponse, CreateImageRequest> {
  
  private ActivityValidatorUtil activityValidatorUtil;
  private IImageService imageService;
  private ImageMapper imageMapper;
  
  @Override
  public CreateImageResponse execute(CreateImageRequest request) {
    
    Activity activity = activityValidatorUtil.valdaiteActivityId(request.getActivityId());
  
    Image createImageRequest = imageMapper.createImageRequestToImage(request, activity);
    
    return new CreateImageResponse(
      imageMapper.imageToImageDto(imageService.save(createImageRequest))
    );
  }
}
