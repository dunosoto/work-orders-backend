package com.diplomado.userservice.mapper;

import com.diplomado.userservice.api.dto.role.RoleDto;
import com.diplomado.userservice.api.request.role.CreateRoleRequest;
import com.diplomado.userservice.domain.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

  Role toRole(CreateRoleRequest request);
  
  RoleDto roleToRoleDto(Role role);
}
