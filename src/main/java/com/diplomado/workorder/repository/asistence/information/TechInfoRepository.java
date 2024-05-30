package com.diplomado.workorder.repository.asistence.information;

import com.diplomado.workorder.domain.assistance.TechnicalInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechInfoRepository extends JpaRepository<TechnicalInformation, UUID> {
}
