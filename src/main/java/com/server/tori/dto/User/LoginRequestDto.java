package com.server.tori.dto.User;

import com.server.tori.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginRequestDto {
  public String email;
  public String password;

}
