package com.server.tori.dto.Landmark;

import com.server.tori.dto.Landmark.LandmarkValueDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MyLandmarkResponseDto {
  public int total;
  public List<LandmarkValueDto> landmarks;

  public MyLandmarkResponseDto(int total,List<LandmarkValueDto> landmarks) {
    this.landmarks = landmarks;
    this.total = total;

  }

}
