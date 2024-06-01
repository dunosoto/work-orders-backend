package com.diplomado.workorder.usecase.assistance;


import com.diplomado.workorder.api.response.assistance.GetAssistanceByIdResponse;
import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.mapper.assistance.AssistanceMapper;
import com.diplomado.workorder.usecase.assistance.util.AssistanceValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GetAssistanceByIdUseCase {

  private AssistanceValidatorUtil assistanceValidatorUtil;
  private AssistanceMapper assistanceMapper;

  public GetAssistanceByIdResponse execute(UUID serviceId) {
    Assistance assistance = this.assistanceValidatorUtil.validateServiceId(serviceId);
    
    return new GetAssistanceByIdResponse(
      assistanceMapper.assistanceToAssistanceDto(assistance)
    );
  }
}
