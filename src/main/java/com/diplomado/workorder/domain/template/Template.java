package com.diplomado.workorder.domain.template;

import com.diplomado.workorder.domain.assistance.Assistance;
import com.diplomado.workorder.domain.group.Group;
import com.diplomado.workorder.domain.template.activity.Activity;
import com.diplomado.workorder.domain.template.enums.TemplatePriority;
import com.diplomado.workorder.domain.template.enums.TemplateStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "templates")
public class Template {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  
  @Column(nullable = false)
  private String description;
  
  @Enumerated(EnumType.STRING)
  private TemplateStatus status = TemplateStatus.OPEN;
  
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TemplatePriority priority;
  
  private Date start;
  
  private Date finish;
  
  @CreationTimestamp
  private Instant createdAt;
  
  @UpdateTimestamp
  private Date updatedAt;
  
  @OneToOne(mappedBy = "workOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private Activity activity;
  
  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;
  
  @ManyToOne
  @JoinColumn(name = "service_id", nullable = false)
  private Assistance assistance;
}
