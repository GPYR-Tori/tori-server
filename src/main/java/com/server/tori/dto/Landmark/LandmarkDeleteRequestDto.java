package com.server.tori.dto.Landmark;

import lombok.Getter;

@Getter
public class LandmarkDeleteRequestDto {
  public Long userId;
  public Long landmarkId;
}
