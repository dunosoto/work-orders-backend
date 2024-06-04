package com.diplomado.workorder.repository.role;

import com.diplomado.workorder.domain.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
