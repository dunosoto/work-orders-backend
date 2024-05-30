package com.diplomado.workorder.mapper.assistance;

import com.diplomado.workorder.api.dto.assistance.AssistanceDto;
import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.domain.assistance.AssistanceType;
import com.diplomado.workorder.domain.client.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssistanceMapper {

  @Mapping(target = "Assistance.address", source = "java(address)")
  @Mapping(target = "Assistance.assistanceType", source = "java(serviceType)")
  Assistance createAssistanceRequestToAssistance(Address address, AssistanceType serviceType);

  AssistanceDto assistanceToAssistanceDto(Assistance assistance);
}
