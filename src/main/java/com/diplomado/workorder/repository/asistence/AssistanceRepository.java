package com.diplomado.workorder.repository.asistence;


import com.diplomado.workorder.domain.assistance.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssistanceRepository extends JpaRepository<Assistance, UUID> {

}
