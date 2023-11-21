package com.diplomado.userservice.mapper;

import com.diplomado.userservice.api.dto.user.UserDetailDto;
import com.diplomado.userservice.api.dto.user.UserDto;
import com.diplomado.userservice.api.request.user.CreateUserRequest;
import com.diplomado.userservice.api.request.user.UpdateUserRequest;
import com.diplomado.userservice.domain.User;
import com.diplomado.userservice.domain.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
  
  @Mapping(target = "userDetail", expression = "java(detail)")
  User createUserRequestToUser(CreateUserRequest request, UserDetail detail);
  
  
  @Mapping(target = "userDetail", expression = "java(detail)")
  User updateUserRequestToUser(UpdateUserRequest request, UserDetail detail);

  @Mapping(target = "id", source = "user.id")
  @Mapping(target = "userDetail", expression = "java(userDetailDto)")
  UserDto fromCreateUserResponseToUserDto(User user, UserDetailDto userDetailDto);
  
  @Mapping(target = "id", source = "user.id")
  UserDto userToUserDto(User user);
  
  
}
