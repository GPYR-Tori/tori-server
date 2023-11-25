package com.server.tori.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyPageEditViewResponseDto {
  private Long id;

  private String email;

  private String password;

  private String gender;

  private String nation;

  private String language;

  private String nickname;

}
