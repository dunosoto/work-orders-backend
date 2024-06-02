package com.diplomado.workorder.repository.template.activity;


import com.diplomado.workorder.domain.template.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {
}
