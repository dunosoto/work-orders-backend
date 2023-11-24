package com.diplomado.userservice.controller;


import com.diplomado.userservice.api.request.userrole.UpdateActiveRequest;
import com.diplomado.userservice.api.response.userrole.UserRoleResponse;
import com.diplomado.userservice.usecase.userrole.UpdateUserRoleActiveUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user_roles")
@AllArgsConstructor
public class UserRoleController {
  
  private UpdateUserRoleActiveUseCase updateUserRoleInactiveUseCase;

  @PatchMapping("/{id}")
  public UserRoleResponse updateActive(@RequestBody UpdateActiveRequest request,
                                         @PathVariable("id") Long userRoleId) {
    return updateUserRoleInactiveUseCase.execute(request, userRoleId);
  }
  
}
