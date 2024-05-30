package com.diplomado.workorder.usecase.assistance.information;

import com.diplomado.workorder.api.request.assistance.information.CreateTechInfoRequest;
import com.diplomado.workorder.api.response.assistance.information.CreateTechInfoResponse;
import com.diplomado.workorder.domain.assistance.TechnicalInformation;
import com.diplomado.workorder.mapper.assistance.information.TechInfoMapper;
import com.diplomado.workorder.service.assistance.information.ITechInfoService;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTechInfoUseCase implements BusinessLogicCommand<CreateTechInfoResponse, CreateTechInfoRequest> {
  
  private ITechInfoService techInfoService;
  private TechInfoMapper techInfoMapper;
  
  
  @Override
  public CreateTechInfoResponse execute(CreateTechInfoRequest request) {
  
    TechnicalInformation newTechInfo = techInfoMapper.createTechInfoRequestToTechnicalInformation(request);
    
    return new CreateTechInfoResponse(
      techInfoMapper.technicalInformationToTechInfoDto(techInfoService.save(newTechInfo))
    );
  }
}
