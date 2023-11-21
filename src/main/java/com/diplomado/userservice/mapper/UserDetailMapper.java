package com.diplomado.userservice.mapper;


import com.diplomado.userservice.api.dto.user.UserDetailDto;
import com.diplomado.userservice.api.request.user.CreateUserRequest;
import com.diplomado.userservice.api.request.user.UpdateUserRequest;
import com.diplomado.userservice.domain.UserDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailMapper {

  UserDetail toUserDetail(CreateUserRequest request);
  
  UserDetailDto toUserDetailDto(UserDetail userDetail);
  
  UserDetail fromUpdateUserRequestToUserDetail(UpdateUserRequest request);
  
}
