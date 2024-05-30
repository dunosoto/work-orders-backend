package com.diplomado.workorder.usecase.assistance;


import com.diplomado.workorder.api.response.assistance.AssistanceListResponse;
import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.mapper.assistance.AssistanceMapper;
import com.diplomado.workorder.service.assistance.IAssistanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetAllAssistanceUseCase {

  private IAssistanceService assistanceService;
  private AssistanceMapper assistanceMapper;
  
  public AssistanceListResponse execute() {
  
    List<Assistance> assistanceList = this.assistanceService.getAll();
    
    return new AssistanceListResponse(
      assistanceList.stream().map(assistanceMapper::assistanceToAssistanceDto).collect(Collectors.toList())
    );
  }
}
