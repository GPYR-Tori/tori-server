package com.server.tori.dto;

import com.server.tori.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class JoinResponseDto {

  private Long id;

  private String email;

  private String password;

  private String gender;

  private String nation;

  private String language;

  private String nickname;


}
