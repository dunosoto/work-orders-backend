package com.diplomado.workorder.domain.user;

import com.diplomado.workorder.domain.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user_roles")
public class UserRole {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false)
  private boolean active;
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false)
  private Date createdAt;
  
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

}
