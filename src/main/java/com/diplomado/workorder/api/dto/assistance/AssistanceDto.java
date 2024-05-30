package com.diplomado.workorder.api.dto.assistance;

import com.diplomado.workorder.domain.assistance.AssistanceType;
import com.diplomado.workorder.domain.client.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class AssistanceDto {
  
  private UUID id;
  private boolean activated;
  private Instant createdAt;
  private Date updatedAt;
  private Address address;
  private AssistanceType assistanceType;
}
