package com.diplomado.workorder.domain.user;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.diplomado.workorder.domain.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(length = 100, nullable = false)
  private String firstName;
  
  @Column(length = 100, nullable = false)
  private String lastName;

  @Column(length = 150, nullable = false)
  private String password;
  
  @Column(length = 150, nullable = false)
  private String email;
  
//  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  private Instant createdAt;
  
  @UpdateTimestamp
  private Date updatedAt;
  
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;
  
  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<UserGroup> groups;
}
