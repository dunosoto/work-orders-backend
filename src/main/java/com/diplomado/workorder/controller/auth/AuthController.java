package com.diplomado.workorder.controller.auth;

import com.diplomado.workorder.api.request.auth.LoginRequest;
import com.diplomado.workorder.api.response.auth.LoginResponse;
import com.diplomado.workorder.usecase.auth.LoginUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {

  private LoginUseCase loginUseCase;

  @PostMapping("login")
  public LoginResponse login(@RequestBody LoginRequest request) {
    return loginUseCase.execute(request);
  }
}
