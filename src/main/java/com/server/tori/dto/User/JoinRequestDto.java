package com.server.tori.dto.User;

import com.server.tori.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinRequestDto {
  private Long id;

  private String email;

  private String password;

  private String gender;

  private String nation;

  private String language;

  private String nickname;

  public User toEntity() {
    return new User(id, email, password, gender, nation, language, nickname);
  }
}