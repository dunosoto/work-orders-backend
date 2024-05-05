package com.diplomado.workorder.mapper;


import com.diplomado.workorder.api.dto.user.UserDetailDto;
import com.diplomado.workorder.api.request.user.CreateUserRequest;
import com.diplomado.workorder.api.request.user.UpdateUserRequest;
import com.diplomado.workorder.domain.user.UserDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailMapper {

  UserDetail createUserRequestToUserDetail(CreateUserRequest request);
  
  UserDetailDto toUserDetailDto(UserDetail userDetail);
  
  UserDetail fromUpdateUserRequestToUserDetail(UpdateUserRequest request);
  
}
