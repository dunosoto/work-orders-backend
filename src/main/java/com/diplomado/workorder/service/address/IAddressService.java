package com.diplomado.workorder.service.address;

import com.diplomado.workorder.domain.client.Address;
import com.diplomado.workorder.service.BusinessServiceCommand;

import java.util.UUID;

public interface IAddressService extends BusinessServiceCommand<Address, UUID> {
}
