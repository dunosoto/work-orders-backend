package com.diplomado.workorder.domain.template.activity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "images")
public class Image {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  
  @Lob
  @Column(length = 512 ,nullable = false)
  private String url;
  
  @ManyToOne
  @JoinColumn(name = "activity_id")
  private Activity activity;

}
