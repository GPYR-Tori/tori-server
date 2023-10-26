package com.server.tori.dto;

import lombok.Getter;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

@Getter
public class LoginRequestDto {
  private String email;
  private String password;
}
