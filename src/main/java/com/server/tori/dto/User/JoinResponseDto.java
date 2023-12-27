package com.server.tori.dto.User;

import com.server.tori.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinResponseDto {

  private Long id;
  private String email;
  private String password;
  private String gender;
  private String nation;
  private String language;
  private String nickname;

  public JoinResponseDto(User saved) {
    this.id = saved.getId();
    this.email = saved.getEmail();
    this.password = saved.getPassword();
    this.gender = saved.getGender();
    this.nation = saved.getNation();
    this.language = saved.getLanguage();
    this.nickname = saved.getNickname();
  }
}
