package com.diplomado.workorder.mapper.template.activity.image;

import com.diplomado.workorder.api.dto.template.activity.image.ImageDto;
import com.diplomado.workorder.api.request.template.activity.image.CreateImageRequest;
import com.diplomado.workorder.domain.template.activity.Activity;
import com.diplomado.workorder.domain.template.activity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {

  @Mapping(target = "activity", source = "java(activity)")
  Image createImageRequestToImage(CreateImageRequest request, Activity activity);

  
  @Mapping(target = "activityId", source = "java(image.getActivity().getId())")
  ImageDto imageToImageDto(Image image);

}
