package com.server.tori.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.server.tori.dto.User.MyPageEditRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
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

  @OneToMany(mappedBy = "user") //db에 적용이 되지 않는 조회를 목적을 둔 필드(필수가 아닌 양방향 맵핑)
  public List<Like> likes = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  public List<Dotori> dotoris = new ArrayList<>();

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
    if (myPageEditRequestDto.getNation() != null) {
      this.nation = myPageEditRequestDto.getNation();
    }
    if (myPageEditRequestDto.getGender() != null) {
      this.gender = myPageEditRequestDto.getGender();
    }
    if (myPageEditRequestDto.getLanguage() != null) {
      this.language = myPageEditRequestDto.getLanguage();
    }
    if (myPageEditRequestDto.getNickname() != null) {
      this.nickname = myPageEditRequestDto.getNickname();
    }
  }

  public void insertLike(Like like){
    this.likes.add(like);
    like.setUser(this);
  }

  public void insertDotori(Dotori dotori){
    this.dotoris.add(dotori);
    dotori.setUser(this);
  }
}
