package com.server.tori.dto.Landmark;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LandmarkValueDto {
  public Long landmarkId;
  public String landmarkName;
  public List<String> landmarkImage;
  public List<String> landmarkCategori;

  public LandmarkValueDto(Long landmarkId, String landmarkName, List<String> landmarkImage, List<String> landmarkCategori) {
    this.landmarkId = landmarkId;
    this.landmarkName = landmarkName;
    this.landmarkImage = landmarkImage;
    this.landmarkCategori = landmarkCategori;
  }
}
