package com.diplomado.workorder.usecase.assistance.util;

import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.exception.assistance.NotFoundAssistanceException;
import com.diplomado.workorder.service.assistance.IAssistanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AssistanceValidatorUtil {

  private IAssistanceService assistanceService;
  private Message message;
  
  public Assistance validateServiceId(UUID serviceId) {
    Optional<Assistance> assistance = this.assistanceService.findById(serviceId);
    
    if (assistance.isEmpty()) {
      throw new NotFoundAssistanceException(message.getMessage("Service.not.found"));
    }
    
    return assistance.get();
  }

}
