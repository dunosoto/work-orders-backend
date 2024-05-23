package com.diplomado.workorder.domain.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(length = 30, nullable = false)
  private String latitude;

  @Column(length = 30, nullable = false)
  private String longitude;

  @Column(length = 30, nullable = false)
  private String city;
  
  @Column(length = 30, nullable = false)
  private String direction;

  @Column(length = 50, nullable = false)
  private String description;
  
  private boolean actived = true;

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;
}
