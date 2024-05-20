package com.diplomado.workorder.repository.client;


import com.diplomado.workorder.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {


}
