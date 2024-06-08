package com.diplomado.workorder.controller.user;


import com.diplomado.workorder.api.request.user.CreateUserRequest;
import com.diplomado.workorder.api.request.user.UpdateUserRequest;
import com.diplomado.workorder.api.response.user.CreateUserResponse;
import com.diplomado.workorder.api.response.user.UserListResponse;
import com.diplomado.workorder.api.response.user.UserResponse;
import com.diplomado.workorder.usecase.user.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
  
  private GetAllUsersUseCase getAllUsersUseCase;
  private GetUserByIdUseCase getUserByIdUseCase;
  private CreateUserUseCase createUserUseCase;
  private UpdateUserUseCase updateUserUseCase;
  private DeleteUserUseCase deleteUserUseCase;

  @PostMapping("/create")
  public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
    return createUserUseCase.execute(request);
  }

  @GetMapping()
  public UserListResponse getUsers() {
    return getAllUsersUseCase.execute();
  }
  
  @GetMapping("/{id}")
  public UserResponse getUserById(@PathVariable("id") Long userId) {
    return getUserByIdUseCase.execute(userId);
  }

  @PutMapping("/{id}")
  public UserResponse updateUser(@RequestBody UpdateUserRequest request, @PathVariable("id") Long userId) {
    return updateUserUseCase.execute(request, userId);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") Long userId) {
    deleteUserUseCase.execute(userId);
  }
}
