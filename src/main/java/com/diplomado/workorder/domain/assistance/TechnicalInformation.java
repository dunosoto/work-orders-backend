package com.diplomado.workorder.domain.assistance;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "technicals_information")
public class TechnicalInformation {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  
  @Column(length = 20)
  private String olt;
  
  @Column(length = 10, name = "olt_ip")
  private String oltIp;
  
  @Column(length = 10, name = "gpon_port")
  private String gponPort;
  
  @Column(length = 10, name = "mdu_ip")
  private String mduIp;
  
  @Column(length = 10, name = "mdu_port")
  private String mduPort;
  
  @CreationTimestamp
  private Instant createdAt;
  
  @UpdateTimestamp
  private Date updatedAt;
  
  @ManyToOne
  @JoinColumn(name = "service_id", nullable = false)
  private Assistance assistance;
  
}
