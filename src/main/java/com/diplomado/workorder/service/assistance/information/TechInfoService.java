package com.diplomado.workorder.service.assistance.information;

import com.diplomado.workorder.domain.assistance.TechnicalInformation;
import com.diplomado.workorder.repository.asistence.information.TechInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TechInfoService implements ITechInfoService {
  
  private TechInfoRepository techInfoRepository;
  
  @Override
  public TechnicalInformation save(TechnicalInformation technicalInformation) {
    return this.techInfoRepository.save(technicalInformation);
  }
  
  @Override
  public List<TechnicalInformation> getAll() {
    return null;
  }
  
  @Override
  public Optional<TechnicalInformation> findById(UUID techInfoId) {
    return Optional.empty();
  }
  
  @Override
  public TechnicalInformation update(TechnicalInformation technicalInformation) {
    return null;
  }
}
