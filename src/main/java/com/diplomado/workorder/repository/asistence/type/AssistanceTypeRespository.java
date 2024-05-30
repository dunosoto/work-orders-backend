package com.diplomado.workorder.repository.asistence.type;


import com.diplomado.workorder.domain.assistance.AssistanceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssistanceTypeRespository extends JpaRepository<AssistanceType, UUID> {
}
