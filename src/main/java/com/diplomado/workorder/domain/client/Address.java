package com.diplomado.workorder.domain.client;

import com.diplomado.workorder.domain.assistance.Assistance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
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
  
  private boolean activated = true;

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;
  
  //TODO: INCLUDE CREATED_AT AND UPDATED_AT COLUMNS
  
  @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<Assistance> services;
}
