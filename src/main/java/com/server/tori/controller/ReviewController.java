package com.server.tori.controller;

import com.server.tori.dto.Review.*;
import com.server.tori.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/landmarks/{landmarkId}/reviews")
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 생성
    @PostMapping
    public ResponseEntity<ReviewCreateResponseDto> createReview(@PathVariable("landmarkId") Long landmarkId, @RequestBody ReviewCreateRequestDto reviewCreateRequestDto){
        return ResponseEntity.ok().body(reviewService.createReview(landmarkId, reviewCreateRequestDto));
    }

    // 리뷰 조회 (+ 댓글 조회 함께)
    @GetMapping
    public ResponseEntity<List<ReviewGetResponseDto>> getReview(@PathVariable("landmarkId") Long landmarkId){
        return ResponseEntity.ok().body(reviewService.getReview(landmarkId));
    }

    // 리뷰 수정
    @PatchMapping("/{reviewId}")
    public ResponseEntity<ReviewUpdateResponseDto> updateReview(@PathVariable("landmarkId") Long landmarkId, @PathVariable("reviewId") Long id, @RequestBody ReviewUpdateRequestDto reviewUpdateRequestDto){
        return ResponseEntity.ok().body(reviewService.updateReview(landmarkId, id, reviewUpdateRequestDto));
    }

    // 리뷰 삭제
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable("landmarkId") Long landmarkId, @PathVariable("reviewId") Long id, @RequestBody ReviewDeleteRequestDto reviewDeleteRequestDto){
        return ResponseEntity.ok().body(reviewService.deleteReview(landmarkId, id, reviewDeleteRequestDto));

    }
}
