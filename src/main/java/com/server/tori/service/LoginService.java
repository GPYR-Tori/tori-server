package com.server.tori.service;

import com.server.tori.dto.User.*;
import com.server.tori.entity.User;
import com.server.tori.exception.CustomException;
import com.server.tori.exception.ErrorCode;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  @Autowired
  private UserRepository userRepository;


  public LoginResponseDto login(LoginRequestDto loginRequestDto) {
  // 1. dto로 받은 요청 이메일값으로 db user 엔티티 조회
    User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow(()->new IllegalArgumentException("저장된 메일 주소 없음"));
  // 2. 해당 user에 저장되어있는 password == != 요청으로 받은 password 일치
    if (!loginRequestDto.getPassword().equals(user.getPassword())) //수정함 이렇게 하면 문자열 내용을 비교하는 것이 아니라 참조 비교를 하게 됩니다. 문자열 비교에는 .equals() 메서드를 사용해야 합니다.
      { throw new CustomException(ErrorCode.PASSWORD_NOT_EQUIR);}
      return new LoginResponseDto(user.getEmail(), user.getId());
    }

  public CheckEmailResponseDto checkEmail(CheckEmailRequestDto checkEmailRequestDto) {
    if (userRepository.findByEmail(checkEmailRequestDto.getEmail()).isPresent()) {
      throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
    }
    return new CheckEmailResponseDto(checkEmailRequestDto.getEmail());
  }

  // 회원가입(/join)의 중복확인
  public CheckNicknameResponseDto checkNickname(CheckNicknameRequestDto checkNicknameRequestDto) {
    if (userRepository.findByNickname(checkNicknameRequestDto.getNickname()).isPresent()) {
      throw new CustomException(ErrorCode.DUPLICATE_NICKNAME);
    }
    return new CheckNicknameResponseDto(checkNicknameRequestDto.getNickname());
  }
}
