package com.diplomado.workorder.service.assistance.type;

import com.diplomado.workorder.domain.assistance.AssistanceType;
import com.diplomado.workorder.repository.asistence.type.AssistanceTypeRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AssistanceTypeService implements IAssistanceTypeService {
  
  private AssistanceTypeRespository assistanceTypeRespository;
  
  @Override
  public AssistanceType save(AssistanceType assistanceType) {
    return null;
  }
  
  @Override
  public List<AssistanceType> getAll() {
    return null;
  }
  
  @Override
  public Optional<AssistanceType> findById(UUID uuid) {
    return this.assistanceTypeRespository.findById(uuid);
  }
  
  @Override
  public AssistanceType update(AssistanceType assistanceType) {
    return null;
  }
}
