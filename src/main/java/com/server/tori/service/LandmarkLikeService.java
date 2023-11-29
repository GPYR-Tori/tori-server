package com.server.tori.service;

import com.server.tori.dto.Landmark.LandmarkLikeRequestDto;
import com.server.tori.dto.Landmark.LandmarkLikeResponseDto;
import com.server.tori.dto.Landmark.LandmarkValueDto;
import com.server.tori.dto.Landmark.MyLandmarkResponseDto;
import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Like;
import com.server.tori.repository.LandmarkRepository;
import com.server.tori.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LandmarkLikeService {
  @Autowired
  LikeRepository likeRepository;
  @Autowired
  LandmarkRepository landmarkRepository;

  public LandmarkLikeResponseDto landmarkLike(LandmarkLikeRequestDto landmarkLikeRequestDto) {
  // dto를 entity로 변환 -> 레파지토리로 저장하기 위해
  Like like = landmarkLikeRequestDto.toEntity();
  // 레포지토리에 저장
  Like saved = likeRepository.save(like);
  // 저장한 객체에서 Dto에 데이터 변환하기
    return new LandmarkLikeResponseDto(saved.getUserId(),saved.getLandmarkId());
  }

  public MyLandmarkResponseDto myLandmark(Long user_Id) {
    List<Like> userLike = likeRepository.findAllByUserId(user_Id);
    // 1. Landmark likeUser에서 항목들을 넣어준다.
    List<LandmarkValueDto> landmarkValueDtos = new ArrayList<>();

    for (Like entity : userLike) {
      Landmark likeUser = landmarkRepository.findById(entity.getLandmarkId()).orElseThrow(() -> new RuntimeException("여행지를 찾을 수 없습니다")); //해당유저가 좋아요한 여행지
      landmarkValueDtos.add(new LandmarkValueDto(likeUser.getId(), likeUser.getName(), likeUser.getCategory(), likeUser.getImage()));
    }

    return new MyLandmarkResponseDto(landmarkValueDtos, user_Id);
  }

  public void landmarkLikeDelete(Long landmarkId) {
    // 1. 삭제할 대상 가져오기
    Like target = likeRepository.findByLandmarkId(landmarkId).orElseThrow(() -> new RuntimeException("삭제할 여행지가 없습니다."));
    // 2. db에서 제거
      likeRepository.delete(target);
  }
}

