package com.diplomado.workorder.domain.group;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class UserGroupKey implements Serializable {

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "group_id")
  private Long groupId;
}
