package com.diplomado.workorder.api.dto.assistance.information;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class TechInfoDto {
  private UUID id;
  private String olt;
  private String oltIp;
  private String gponPort;
  private String mduIp;
  private String mduPort;
  private Instant createdAt;
  private Date updatedAt;
  private UUID serviceId;
}
