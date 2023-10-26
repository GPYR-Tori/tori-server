package com.server.tori.controller;

import com.server.tori.dto.LoginRequestDto;
import com.server.tori.dto.LoginResponseDto;
import com.server.tori.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  @Autowired
  private LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
    // 서비스 호출
    LoginResponseDto loginDto = loginService.login(loginRequestDto);
    return ResponseEntity.status(HttpStatus.OK).body(loginDto);
  }

//  @PostMapping("/join")
//
//  @PostMapping("/check/email")
//
//  @PostMapping("/check/id")
//
//  @PostMapping("/logout")

}
