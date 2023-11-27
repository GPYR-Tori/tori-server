package com.server.tori.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyPageEditResponseDto {
  private Long id;

  private String email;

  private String password;

  private String gender;

  private String nation;

  private String language;

  private String nickname;

}
