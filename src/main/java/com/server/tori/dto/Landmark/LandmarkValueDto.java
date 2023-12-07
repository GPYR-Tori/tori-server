package com.server.tori.dto.Landmark;

import com.server.tori.entity.Landmark.Category;
import com.server.tori.entity.Landmark.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LandmarkValueDto {
  public Long landmarkId;
  public String landmarkName;
  public List<Image> landmarkImage;
  public List<Category> landmarkCategory;

  public LandmarkValueDto(Long landmarkId, String landmarkName, List<Image> landmarkImage, List<Category> landmarkCategory) {
    this.landmarkId = landmarkId;
    this.landmarkName = landmarkName;
    this.landmarkImage = landmarkImage;
    this.landmarkCategory = landmarkCategory;
  }
}
