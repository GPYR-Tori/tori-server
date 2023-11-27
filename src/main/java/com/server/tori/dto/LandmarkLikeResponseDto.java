package com.server.tori.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LandmarkLikeResponseDto {
    public Long userId; // 굳이 줘야될 필요가 있나? 
    public Long landmarkId;

  public LandmarkLikeResponseDto(Long userId, Long landmarkId) {
  }

  public LandmarkLikeResponseDto(Long userId, List<Long> landmarkId) {
  }
}
