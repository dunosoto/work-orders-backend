package com.diplomado.workorder.mapper;

import com.diplomado.workorder.api.dto.role.RoleDto;
import com.diplomado.workorder.api.request.role.CreateRoleRequest;
import com.diplomado.workorder.domain.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

  Role toRole(CreateRoleRequest request);
  
  RoleDto roleToRoleDto(Role role);
}
