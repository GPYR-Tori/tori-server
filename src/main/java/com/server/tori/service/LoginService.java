package com.server.tori.service;

import com.server.tori.dto.LoginRequestDto;
import com.server.tori.dto.LoginResponseDto;
import com.server.tori.entity.User;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  @Autowired
  private UserRepository userRepository;

  public LoginResponseDto login(LoginRequestDto loginRequestDto) {
//    1. dto로 받은 요청 이메일값으로 db user 엔티티 조회
    User user = userRepository.findByEmail(loginRequestDto.getEmail()).get();

//    2. 해당 user에 저장되어있는 password == 요청으로 받은 password 일치
    if (loginRequestDto.getPassword() != user.getPassword())
      { throw new RuntimeException();}
      return new LoginResponseDto(user.getEmail(), user.getId());

    }
}
