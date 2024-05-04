package com.diplomado.workorder.repository;

import com.diplomado.workorder.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
