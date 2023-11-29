package com.server.tori.dto.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
