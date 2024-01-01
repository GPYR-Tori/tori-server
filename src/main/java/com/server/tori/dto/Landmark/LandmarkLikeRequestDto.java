package com.server.tori.dto.Landmark;

import com.server.tori.entity.Like;
import lombok.Getter;

@Getter
public class LandmarkLikeRequestDto {
  private Long userId; // 누가 좋아요 누른지 알아야되니까
  private Long landmarkId; // 어떤 여행지를 좋아요 누른지 알아야 되니까

}
