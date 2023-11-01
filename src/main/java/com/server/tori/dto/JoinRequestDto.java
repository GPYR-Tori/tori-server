package com.server.tori.dto;

import com.server.tori.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class JoinRequestDto {

  @Id
  @GeneratedValue //
  private Long id;

  private String email;

  private String password;

  private LocalDate birthdate;

  private String gender;

  private String nation;

  private String language;

  private String nickname;

  public User toEntity() {

    return new User(id, email, password, birthdate, gender, nation, language, nickname);
  }
}
