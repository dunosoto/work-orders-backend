package com.diplomado.workorder.domain.template.activity;

import com.diplomado.workorder.domain.template.Template;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "activities")
public class Activity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  
  @Column(nullable = false)
  private String process;
  
  @Column()
  private String observation;
  
  @OneToOne
  @JoinColumn(name = "work_order_id")
  private Template workOrder;
  
  @OneToMany(mappedBy = "activity", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<Image> images;
}
