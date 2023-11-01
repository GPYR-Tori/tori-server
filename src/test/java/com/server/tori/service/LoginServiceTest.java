package com.server.tori.service;

import com.server.tori.dto.LoginRequestDto;
import com.server.tori.dto.LoginResponseDto;
import com.server.tori.entity.User;
import com.server.tori.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceTest {

  @Autowired
  LoginService loginService;

  @Test
  void login() {
    //1. 예상 데이터
    String email = "jhjune@naver.com";
    String password = "a123123";
    LoginRequestDto dto = new LoginRequestDto(email, password);
    User expected = new User(1l, email, password);
    //2. 실제 데이터
    LoginResponseDto real = loginService.login(dto);
    //3. 비교 및 검증
    assertEquals(expected,real);
  }
}