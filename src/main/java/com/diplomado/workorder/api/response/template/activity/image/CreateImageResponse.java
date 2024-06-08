package com.diplomado.workorder.api.response.template.activity.image;

import com.diplomado.workorder.api.constant.ResponseConstant;
import com.diplomado.workorder.api.dto.template.activity.image.ImageDto;
import com.diplomado.workorder.api.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateImageResponse extends CommonResponse<ImageDto> {
  
  public CreateImageResponse(ImageDto imageDto) {
    super(
      ResponseConstant.StatusCodeResponse.SUCCESS_STATUS,
      ResponseConstant.StatusCodeResponse.CREATED_SUCCESS_MSG,
      imageDto
    );
  }
}
