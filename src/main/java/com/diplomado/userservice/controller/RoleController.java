package com.diplomado.userservice.controller;

import com.diplomado.userservice.api.request.role.CreateRoleRequest;
import com.diplomado.userservice.api.request.role.UpdateRoleRequest;
import com.diplomado.userservice.api.response.role.CreateRoleResponse;
import com.diplomado.userservice.api.response.role.RoleListResponse;
import com.diplomado.userservice.api.response.role.RoleResponse;
import com.diplomado.userservice.usecase.role.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roles")
@AllArgsConstructor
public class RoleController {
  
  @Autowired
  private CreateRoleUseCase createRoleUseCase;
  private GetAllRolesUseCase getAllRolesUseCase;
  private GetRoleByIdUseCase getRoleByIdUseCase;
  private UpdateRoleUseCase updateRoleUseCase;
  private DeleteRoleUseCase deleteRoleUseCase;
  
  @PostMapping()
  public CreateRoleResponse createRole(@RequestBody CreateRoleRequest request) {
    return createRoleUseCase.execute(request);
  }
  
  @GetMapping()
  public RoleListResponse getRoles() {
    return getAllRolesUseCase.execute();
  }
  
  @GetMapping("/{id}")
  public RoleResponse getRoles(@PathVariable("id") Long roleId) {
    return getRoleByIdUseCase.execute(roleId);
  }
  
  @PutMapping("/{id}")
  public RoleResponse updateRole(@RequestBody UpdateRoleRequest request, @PathVariable("id") Long roleId) {
    return updateRoleUseCase.execute(request, roleId);
  }
  
  @DeleteMapping("/{id}")
  public void deleteRole(@PathVariable("id") Long roleId) {
    deleteRoleUseCase.execute(roleId);
  }
  
}
