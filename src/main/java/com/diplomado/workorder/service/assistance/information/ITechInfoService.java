package com.diplomado.workorder.service.assistance.information;

import com.diplomado.workorder.domain.assistance.TechnicalInformation;
import com.diplomado.workorder.service.BusinessServiceCommand;

import java.util.UUID;

public interface ITechInfoService extends BusinessServiceCommand<TechnicalInformation, UUID> {
}
