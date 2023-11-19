package com.diplomado.userservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
  
  @GetMapping()
  public String getUsers(@RequestParam(value = "name", defaultValue = "world") String name) {
    return String.format("Hello %s!", name);
  }


}
