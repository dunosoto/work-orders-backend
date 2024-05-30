package com.diplomado.workorder.usecase.assistance;

import com.diplomado.workorder.api.request.assistance.CreateAssistanceRequest;
import com.diplomado.workorder.api.response.assistance.CreateAssistanceResponse;
import com.diplomado.workorder.common.Message;
import com.diplomado.workorder.domain.assistance.AssistanceType;
import com.diplomado.workorder.domain.client.Address;
import com.diplomado.workorder.exception.address.NotFoundAddressException;
import com.diplomado.workorder.exception.assistance.type.NotFoundAssistanceTypeException;
import com.diplomado.workorder.mapper.assistance.AssistanceMapper;
import com.diplomado.workorder.service.address.IAddressService;
import com.diplomado.workorder.service.assistance.IAssistanceService;
import com.diplomado.workorder.service.assistance.type.IAssistanceTypeService;
import com.diplomado.workorder.usecase.BusinessLogicCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreateAssistanceUseCase implements BusinessLogicCommand<CreateAssistanceResponse, CreateAssistanceRequest> {
  
  private IAssistanceTypeService assistanceTypeService;
  //TODO: FIGURE OUT TO WAY TO VALIDATE IDs INTO THE REQUEST CLASS
  private IAddressService addressService;
  private IAssistanceService assistanceService;
  private AssistanceMapper assistanceMapper;
  private Message message;
  
  
  @Override
  public CreateAssistanceResponse execute(CreateAssistanceRequest request) {
    Address address = this.validateAddress(request.getAddressId());
    AssistanceType serviceType = this.validateServiceType(request.getTypeId());
    
    return new CreateAssistanceResponse(
      this.assistanceMapper.assistanceToAssistanceDto(
        this.assistanceService.save(
          this.assistanceMapper.createAssistanceRequestToAssistance(address, serviceType)
        )
      )
    );
  }
  
  private Address validateAddress(UUID addressId) {
    Optional<Address> addressOptional = this.addressService.findById(addressId);
    
    if (addressOptional.isEmpty()) {
      throw new NotFoundAddressException(message.getMessage("Address.not.found"));
    }

    return addressOptional.get();
  }
  
  private AssistanceType validateServiceType(UUID serviceTypeId) {
    Optional<AssistanceType> addressOptional = this.assistanceTypeService.findById(serviceTypeId);
  
    if (addressOptional.isEmpty()) {
      throw new NotFoundAssistanceTypeException(message.getMessage("ServiceType.not.found"));
    }
  
    return addressOptional.get();
  }
}
