package com.server.tori.dto;

import com.server.tori.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MyPageEditRequestDto {

  private String password;

  private String language;

  private String nickname;


  public User toEntity() {
    return new User(password, language, nickname);
  }
}
