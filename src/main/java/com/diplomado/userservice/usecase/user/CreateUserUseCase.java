package com.diplomado.userservice.usecase.user;

import com.diplomado.userservice.api.request.user.CreateUserRequest;
import com.diplomado.userservice.api.response.user.CreateUserResponse;
import com.diplomado.userservice.domain.Role;
import com.diplomado.userservice.domain.User;
import com.diplomado.userservice.domain.UserDetail;
import com.diplomado.userservice.domain.UserRole;
import com.diplomado.userservice.exception.NotFoundRoleException;
import com.diplomado.userservice.mapper.RoleMapper;
import com.diplomado.userservice.mapper.UserDetailMapper;
import com.diplomado.userservice.mapper.UserMapper;
import com.diplomado.userservice.service.IRoleService;
import com.diplomado.userservice.service.IUserDetailService;
import com.diplomado.userservice.service.IUserRoleService;
import com.diplomado.userservice.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CreateUserUseCase {

  @Autowired
  private IUserService userService;
  
  @Autowired
  private IRoleService roleService;
  
  @Autowired
  private IUserDetailService userDetailService;
  
  @Autowired
  private IUserRoleService userRoleService;
  
  private UserMapper userMapper;
  private UserDetailMapper userDetailMapper;
  private RoleMapper roleMapper;
  
  
  public CreateUserResponse execute(CreateUserRequest request, boolean details) {
    List<Role> roleList = validateRoleIds(request.getRoleIds());
    
    User user = userService.save(userMapper.createUserRequestToUser(request));
    
    if (details) userDetailService.save(composeUserDetail(request, user));
  
    saveAllUserRoles(roleList, user);
    
    return new CreateUserResponse(
      userMapper.fromUserToUserDto(
        user,
        userDetailMapper.toUserDetailDto(user.getUserDetail()),
        roleList.stream().map(roleMapper::roleToRoleDto).collect(Collectors.toList())
      )
    );
  }

  private UserDetail composeUserDetail(CreateUserRequest request, User user) {
    UserDetail detail = new UserDetail();
    detail.setUser(user);
    detail.setAge(request.getAge());
    detail.setBirthDay(request.getBirthDay());
    detail.setFirstName(request.getFirstName());
    detail.setLastName(request.getLastName());

    return detail;
  }

  private List<Role> validateRoleIds(List<Long> roleIds) {
    return roleIds.stream().map(roleId -> {
      Optional<Role> role = roleService.findById(roleId);
      if (role.isEmpty()) {
        throw new NotFoundRoleException("not exist a role with the id: ".concat(roleId.toString()));
      }
      return role.get();
    }).collect(Collectors.toList());
  }
  
  private void saveAllUserRoles(List<Role> roleList, User user) {
    List<UserRole> userRoleIterable = new ArrayList<>();
    
    roleList.forEach(role -> {
      UserRole userRole = new UserRole();
      userRoleIterable.add(composeUserRole(userRole, role, user));
    });
  
    userRoleService.saveAll(userRoleIterable);
  }
  
  
  private UserRole composeUserRole(UserRole userRole, Role role, User user) {
    userRole.setRole(role);
    userRole.setUser(user);
    userRole.setActive(true);
    userRole.setCreatedAt(new Date());
    
    return userRole;
  }
  
}
