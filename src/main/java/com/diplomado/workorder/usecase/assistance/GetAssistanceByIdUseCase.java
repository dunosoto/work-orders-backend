package com.diplomado.workorder.usecase.assistance;


import com.diplomado.workorder.api.response.assistance.GetAssistanceByIdResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.exception.assistance.NotFoundAssistanceException;
import com.diplomado.workorder.mapper.assistance.AssistanceMapper;
import com.diplomado.workorder.service.assistance.IAssistanceService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetAssistanceByIdUseCase {

  private IAssistanceService assistanceService;
  private AssistanceMapper assistanceMapper;
  private Message message;
  

  public GetAssistanceByIdResponse execute(UUID serviceId) {
    Assistance assistance = this.validateServiceId(serviceId);
    
    return new GetAssistanceByIdResponse(
      assistanceMapper.assistanceToAssistanceDto(assistance)
    );
  }
  
  private Assistance validateServiceId(UUID serviceId) {
    Optional<Assistance> assistance = this.assistanceService.findById(serviceId);
    
    if (assistance.isEmpty()) {
      throw new NotFoundAssistanceException(message.getMessage("Service.not.found"));
    }
    
    return assistance.get();
  }
}
