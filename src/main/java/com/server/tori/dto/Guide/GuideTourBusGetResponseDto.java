package com.server.tori.dto.Guide;

import lombok.Getter;

@Getter

public class GuideTourBusGetResponseDto {
  public String content;

  public GuideTourBusGetResponseDto(String content) {
    this.content = content;
  }
}
