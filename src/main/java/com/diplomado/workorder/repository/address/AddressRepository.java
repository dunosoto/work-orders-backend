package com.diplomado.workorder.repository.address;


import com.diplomado.workorder.domain.client.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
