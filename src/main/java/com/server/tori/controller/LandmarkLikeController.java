package com.server.tori.controller;

import com.server.tori.dto.LandmarkLikeResponseDto;
import com.server.tori.dto.LandmarkLikeRequestDto;
import com.server.tori.dto.MyLandmarkResponseDto;
import com.server.tori.service.LandmarkLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LandmarkLikeController {
  @Autowired
  LandmarkLikeService landmarkLikeService;


  @PostMapping("/landmarks/{landmark_id}/like")
  public ResponseEntity<LandmarkLikeResponseDto> landmark_like(@RequestBody LandmarkLikeRequestDto landmarkRequestDto) {
    // 1. 서비스에 보내서 레파지토리에 좋아요 누른 여행지 저장한 내용 불러오기
    LandmarkLikeResponseDto landmarkLikeDto = landmarkLikeService.landmarkLike(landmarkRequestDto);

    // 3. 리턴
    return ResponseEntity.status(HttpStatus.OK).body(landmarkLikeDto);
  }

  // 여행지 좋아요 조회
  @GetMapping("/user/{user_id}/mylandmarks")
  public ResponseEntity<MyLandmarkResponseDto> myLandmarks(@PathVariable Long user_id) {
    MyLandmarkResponseDto myLandmarksDto = landmarkLikeService.myLandmark(user_id);
    return ResponseEntity.status(HttpStatus.OK).body(myLandmarksDto);
  }

}