package com.diplomado.workorder.service.role;

import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.service.BusinessServiceCommand;

public interface IRoleService extends BusinessServiceCommand<Role, Long> {
  
  void deleteById(Long id);
}
