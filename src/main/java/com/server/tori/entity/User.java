package com.server.tori.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.server.tori.dto.User.MyPageEditRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userinfo")
@Entity
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  public Long id;

  public String email;

  public String password;

  public String gender;

  public String nation;

  public String language;

  public String nickname;

  public User(String password, String gender, String nation ,String language, String nickname) {
    this.password = password;
    this.gender = gender;
    this.nation = nation;
    this.language = language;
    this.nickname = nickname;
  }

  public User(String email, String password, String gender, String nation, String language, String nickname) {
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.nation = nation;
    this.language = language;
    this.nickname = nickname;
  }

  public void patch(MyPageEditRequestDto myPageEditRequestDto) {
    if (myPageEditRequestDto.getPassword() != null) {
      this.password = myPageEditRequestDto.getPassword();
    }
    if (myPageEditRequestDto.getLanguage() != null) {
      this.language = myPageEditRequestDto.getLanguage();
    }
    if (myPageEditRequestDto.getNickname() != null) {
      this.nickname = myPageEditRequestDto.getNickname();
    }
  }

}
