package com.server.tori.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MyLandmarkResponseDto {
  public List<LandmarkValueDto> landmarks;
  public Long userId;

  public MyLandmarkResponseDto(List<LandmarkValueDto> landmarks, Long userId) {
    this.landmarks = landmarks;
    this.userId = userId;
  }

}
