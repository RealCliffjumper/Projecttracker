package com.projecttracker.api.controller;

import com.projecttracker.api.dto.UserReq;
import com.projecttracker.api.model.User;
import com.projecttracker.api.service.UserRegistrationService;
import com.projecttracker.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  private UserService userService;

  @PostMapping(path = "/registration")
  public UUID signUpUser(@RequestBody UserReq userReq) {
     return userService.signUpUser(userReq).getUserId();
  }

  @PostMapping(path = "/login")
  public User loginUser(@RequestBody UserReq userReq) throws Exception {
    return userService.loginUser(userReq);
  }

  @DeleteMapping(path = "/delete/{userLoginId}")
  public String deleteUser(@PathVariable("userLoginId") String userLoginId){
    userService.deleteUser(userLoginId);
    return "deleted";
  }
}