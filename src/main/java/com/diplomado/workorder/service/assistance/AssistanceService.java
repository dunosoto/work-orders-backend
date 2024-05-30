package com.diplomado.workorder.service.assistance;

import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.repository.asistence.AssistanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AssistanceService implements IAssistanceService {

  private AssistanceRepository asistenceRepository;

  @Override
  public Assistance save(Assistance assistance) {
    return this.asistenceRepository.save(assistance);
  }

  @Override
  public List<Assistance> getAll() {
    return this.asistenceRepository.findAll();
  }

  @Override
  public Optional<Assistance> findById(UUID uuid) {
    return this.asistenceRepository.findById(uuid);
  }

  @Override
  public Assistance update(Assistance assistance) {
    return this.asistenceRepository.save(assistance);
  }
}
