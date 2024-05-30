package com.diplomado.workorder.api.request.assistance.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class CreateTechInfoRequest {
  
  @JsonProperty("service_id")
  private UUID serviceId;
  
  @JsonProperty("olt")
  private String olt;
  
  @JsonProperty("olt_ip")
  private String oltIp;
  
  @JsonProperty("gpon_port")
  private String gponPort;
  
  @JsonProperty("mdu_ip")
  private String mduIp;
  
  @JsonProperty("mdu_port")
  private String mduPort;
}
