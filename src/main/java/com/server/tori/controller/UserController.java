package com.server.tori.controller;

import com.server.tori.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

//  @GetMapping("/users/{user_id}")
//
//  @PatchMapping("/users/{user_id}")
//
//  @GetMapping("/users/{user_id}/edit")



}
