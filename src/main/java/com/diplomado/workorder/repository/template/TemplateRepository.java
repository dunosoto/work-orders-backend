package com.diplomado.workorder.repository.template;


import com.diplomado.workorder.domain.template.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemplateRepository extends JpaRepository<Template, UUID> {
}
