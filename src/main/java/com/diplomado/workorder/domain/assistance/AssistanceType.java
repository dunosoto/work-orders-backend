package com.diplomado.workorder.domain.assistance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "service_types")
public class AssistanceType {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  //TODO: consider the possibility to convert to AsistenceTypeEnum
  // INTERNET, IPTV, DATOS, VOZ IP
  @Column(length = 30, nullable = false)
  private String name;
  
  @CreationTimestamp
  private Instant createdAt;
  
  @UpdateTimestamp
  private Date updatedAt;
  
  
  @OneToMany(mappedBy = "assistanceType", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<Assistance> services;
}
