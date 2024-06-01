package com.diplomado.workorder.service.template;

import com.diplomado.workorder.domain.template.Template;
import com.diplomado.workorder.service.BusinessServiceCommand;

import java.util.UUID;

public interface ITemplateService extends BusinessServiceCommand<Template, UUID> {
}
