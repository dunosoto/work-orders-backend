package com.diplomado.workorder.mapper.user;

import com.diplomado.workorder.api.dto.role.RoleDto;
import com.diplomado.workorder.api.dto.user.UserDto;
import com.diplomado.workorder.api.request.user.CreateUserRequest;
import com.diplomado.workorder.api.request.user.UpdateUserRequest;
import com.diplomado.workorder.domain.role.Role;
import com.diplomado.workorder.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "role", expression = "java(role)")
  User createUserRequestToUser(CreateUserRequest request, Role role);
  
  @Mapping(target = "role", expression = "java(roleDto)")
  @Mapping(target = "id", source = "user.id")
  UserDto fromUserToUserDto(User user, RoleDto roleDto);
  
  @Mapping(target = "id", source = "user.id")
  UserDto userToUserDto(User user);
}
