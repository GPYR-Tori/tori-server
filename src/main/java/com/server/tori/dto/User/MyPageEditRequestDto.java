package com.server.tori.dto.User;

import com.server.tori.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MyPageEditRequestDto {

  private String password;

  private String gender;

  private String nation;

  private String language;

  private String nickname;


  public User toEntity() {
    return new User(password, gender, nation, language, nickname);
  }
}
