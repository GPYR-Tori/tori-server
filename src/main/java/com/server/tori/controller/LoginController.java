package com.server.tori.controller;

import com.server.tori.dto.User.*;
import com.server.tori.service.LoginService;
import com.server.tori.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
  @Autowired
  private LoginService loginService;
  @Autowired
  private UserService userService;

  // 로그인
  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
    log.info(loginRequestDto.toString());
    LoginResponseDto loginDto = loginService.login(loginRequestDto);
    log.info(loginDto.toString());
    return ResponseEntity.status(HttpStatus.OK).body(loginDto);
  }

  // 회원가입
  @PostMapping("/join")
  // 1. request로 들어온 필드들로 User user = new User (유저 정보값) 넣고 userRepository.save(user)하고 리턴
  public ResponseEntity<JoinResponseDto> join(@RequestBody JoinRequestDto joinRequestDto) {
    log.info("Received Join Request: {}", joinRequestDto);
    if (joinRequestDto.getPassword().length() >= 8) {
      JoinResponseDto joinDto = userService.join(joinRequestDto);
      return ResponseEntity.status(HttpStatus.OK).body(joinDto);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .build();
    }
  }

  // 이메일 중복확인
  @PostMapping("/check/email")
  // 2. findByEmail(dto.email)해서 조회되는 User객체가 있으면 throw new RuntimeException() 없으면 동일한 이메일이 없다는 것이므로 응답값 리턴
  public ResponseEntity<CheckEmailResponseDto> checkEmail(@RequestBody CheckEmailRequestDto checkEmailRequestDto) {
    CheckEmailResponseDto checkEmailDto = loginService.checkEmail(checkEmailRequestDto);
    return ResponseEntity.status(HttpStatus.OK).body(checkEmailDto);

  }
  // 닉네임 중복확인
  @PostMapping("/check/nickname")
  // 2. findByEmail(dto.email)해서 조회되는 User객체가 있으면 throw new RuntimeException() 없으면 동일한 이메일이 없다는 것이므로 응답값 리턴
  public ResponseEntity<CheckNicknameResponseDto> checkNickname(@RequestBody CheckNicknameRequestDto checkNicknameRequestDto) {
    CheckNicknameResponseDto checkEmailDto = loginService.checkNickname(checkNicknameRequestDto);
    return ResponseEntity.status(HttpStatus.OK).body(checkEmailDto);
  }

}
