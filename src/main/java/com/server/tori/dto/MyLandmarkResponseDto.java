package com.server.tori.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MyLandmarkResponseDto {
  public List<Long> landmark_id;
  public Long user_id;

  public MyLandmarkResponseDto(Long user_id, List<Long> landmark_id) {
    this.landmark_id = landmark_id;
    this.user_id = user_id;
  }

}
