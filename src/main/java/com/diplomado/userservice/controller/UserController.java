package com.diplomado.userservice.controller;


import com.diplomado.userservice.api.request.user.CreateUserRequest;
import com.diplomado.userservice.api.request.user.UpdateUserNameRequest;
import com.diplomado.userservice.api.request.user.UpdateUserRequest;
import com.diplomado.userservice.api.response.user.CreateUserResponse;
import com.diplomado.userservice.api.response.user.UserListResponse;
import com.diplomado.userservice.api.response.user.UserResponse;
import com.diplomado.userservice.usecase.user.*;
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
  private UpdateUserNameUseCase updateUserNameUseCase;
  @PostMapping(params = {"details"})
  public CreateUserResponse saveUser(@RequestBody @Valid CreateUserRequest request,
                                     @RequestParam(value = "details", required = false, defaultValue = "true") boolean details) {
    return createUserUseCase.execute(request, details);
  }
  
  @GetMapping(params = {"details"})
  public UserListResponse getUsers(@RequestParam(value = "details", required = false) boolean details) {
    return getAllUsersUseCase.execute(details);
  }
  
  @GetMapping("/{id}")
  public UserResponse getUserById(@PathVariable("id") Long userId) {
    return getUserByIdUseCase.execute(userId);
  }
  
  @PutMapping("/{id}")
  public UserResponse updateUser(@RequestBody UpdateUserRequest request, @PathVariable("id") Long userId) {
    return updateUserUseCase.execute(request, userId);
  }
  
  @PatchMapping("/{id}")
  public UserResponse updateUserName(@RequestBody UpdateUserNameRequest request, @PathVariable("id") Long id) {
    return updateUserNameUseCase.execute(request, id);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") Long userId) {
    deleteUserUseCase.execute(userId);
  }
}
