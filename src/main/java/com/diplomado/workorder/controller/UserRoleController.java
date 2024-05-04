package com.diplomado.workorder.controller;


import com.diplomado.workorder.api.request.userrole.UpdateActiveRequest;
import com.diplomado.workorder.api.response.userrole.UserRoleResponse;
import com.diplomado.workorder.usecase.userrole.UpdateUserRoleActiveUseCase;
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
