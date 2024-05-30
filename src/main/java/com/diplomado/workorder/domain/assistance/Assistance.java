package com.diplomado.workorder.domain.assistance;

import com.diplomado.workorder.domain.client.Address;
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
@Table(name = "services")
public class Assistance {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  
  private boolean activated = true;
  
  @CreationTimestamp
  private Instant createdAt;
  
  @UpdateTimestamp
  private Date updatedAt;
  
  @ManyToOne
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;
  
  @ManyToOne
  @JoinColumn(name = "type_id", nullable = false)
  private AssistanceType assistanceType;
}
