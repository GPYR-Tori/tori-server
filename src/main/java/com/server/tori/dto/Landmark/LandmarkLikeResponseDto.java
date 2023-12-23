package com.server.tori.dto.Landmark;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LandmarkLikeResponseDto {
    public Long userId;
    public Long landmarkId;

  public LandmarkLikeResponseDto(Long userId, Long landmarkId) {
  }

  public LandmarkLikeResponseDto(Long userId, List<Long> landmarkId) {
  }
}
