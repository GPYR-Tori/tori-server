package com.server.tori.service;

import com.server.tori.dto.LandmarkLikeRequestDto;
import com.server.tori.dto.LandmarkLikeResponseDto;
import com.server.tori.dto.MyLandmarkResponseDto;
import com.server.tori.entity.Like;
import com.server.tori.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LandmarkLikeService {
  @Autowired
  LikeRepository likeRepository;

  public LandmarkLikeResponseDto landmarkLike(LandmarkLikeRequestDto landmarkLikeRequestDto) {
// dto를 entity로 변환 -> 레파지토리로 저장하기 위해
  Like like = landmarkLikeRequestDto.toEntity();
// 레포지토리에 저장
  Like saved = likeRepository.save(like);
// 저장한 객체에서 Dto에 데이터 변환하기
// 리턴
    return new LandmarkLikeResponseDto(saved.getUserId(),saved.getLandmarkId());
  }

  public MyLandmarkResponseDto myLandmark(Long user_Id) {
    List<Like> userLike = likeRepository.findAllByUserId(user_Id);
    List<Long> landmarkIds = new ArrayList<>();

    for (Like entity : userLike) {
      landmarkIds.add(entity.getLandmarkId());
    }

    return new MyLandmarkResponseDto(user_Id, landmarkIds);
  }

}

