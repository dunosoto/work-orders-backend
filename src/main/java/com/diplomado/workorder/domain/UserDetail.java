package com.diplomado.workorder.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user_details")
public class UserDetail {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(length = 100, nullable = false)
  private String firstName;
  
  @Column(length = 100, nullable = false)
  private String lastName;
  
  private Integer age;
  
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date birthDay;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
  
  @Override
  public String toString() {
    return "firstname".concat(firstName).concat("\n")
      .concat("lastname").concat(lastName);
  }
}
