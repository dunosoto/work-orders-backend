package com.diplomado.workorder.api.dto.client;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class ClientDto {
  
  private UUID id;
  private String firstName;
  private String lastName;
  private String cellphone;
  private String identityCard;
  private boolean actived;
  private Instant createdAt;
  private Date updatedAt;

}
