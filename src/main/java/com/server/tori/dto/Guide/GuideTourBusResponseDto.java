package com.server.tori.dto.Guide;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

public class GuideTourBusResponseDto {
  public String content;

  public GuideTourBusResponseDto(String content) {
    this.content = content;
  }
}
