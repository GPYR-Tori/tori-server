package com.server.tori.dto;

import com.server.tori.entity.Like;

public class LandmarkLikeRequestDto {
  public Long userId; // 누가 좋아요 누른지 알아야되니까
  public Long landmarkId; // 어떤 여행지를 좋아요 누른지 알아야 되니까

  public Like toEntity() {
    return new Like(userId, landmarkId);
  }

}
