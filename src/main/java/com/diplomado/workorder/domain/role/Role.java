package com.diplomado.workorder.domain.role;

import com.diplomado.workorder.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(length = 100, nullable = false)
  private String prefix;

  @Column(length = 100, nullable = false)
  private String name;

  @OneToMany(mappedBy = "role")
  private List<User> user;
}
