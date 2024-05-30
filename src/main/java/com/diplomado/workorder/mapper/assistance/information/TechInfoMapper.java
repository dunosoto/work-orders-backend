package com.diplomado.workorder.mapper.assistance.information;

import com.diplomado.workorder.api.dto.assistance.information.TechInfoDto;
import com.diplomado.workorder.api.request.assistance.information.CreateTechInfoRequest;
import com.diplomado.workorder.domain.assistance.TechnicalInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechInfoMapper {

  TechnicalInformation createTechInfoRequestToTechnicalInformation(CreateTechInfoRequest request);
  
  TechInfoDto technicalInformationToTechInfoDto(TechnicalInformation technicalInformation);

}
