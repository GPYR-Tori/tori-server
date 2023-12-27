package com.server.tori.dto.User;

import com.server.tori.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequestDto {

  private String email;

  private String password;

  private String gender;

  private String nation;

  private String language;

  private String nickname;

  public JoinRequestDto(String email, String password, String gender,String nation,String language, String nickname){
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.nation = nation;
    this.language = language;
    this.nickname = nickname;
  }

  public User toEntity() {
    return new User(email, password, gender, nation, language, nickname);
  }
}
