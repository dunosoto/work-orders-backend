package com.diplomado.workorder.domain.user;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(length = 150, nullable = false)
  private String userName;
  
  @Column(length = 150, nullable = false)
  private String password;
  
  @Column(length = 150, nullable = false)
  private String email;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
  
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private UserDetail userDetail;
  
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<UserRole> userRoles;
  
  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<UserGroup> groups;
}
