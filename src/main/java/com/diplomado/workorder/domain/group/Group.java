package com.diplomado.workorder.domain.group;

import com.diplomado.workorder.domain.user.UserGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group {
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false)
  private String prefix;
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at")
  private Date createdAt;
  
  @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<UserGroup> members;
}
