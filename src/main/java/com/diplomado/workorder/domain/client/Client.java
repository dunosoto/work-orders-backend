package com.diplomado.workorder.domain.client;


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
@Table(name = "clients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(length = 30, name = "first_name", nullable = false)
  private String firstName;
  
  @Column(length = 30, name = "last_name", nullable = false)
  private String lastName;

  @Column(length = 10)
  private String telephone;

  @Column(length = 20)
  private String identityCard;

  private boolean actived = true;

  @CreationTimestamp
  private Instant createdAt;

  @UpdateTimestamp
  private Date updatedAt;

  @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<Address> addresses;
}
