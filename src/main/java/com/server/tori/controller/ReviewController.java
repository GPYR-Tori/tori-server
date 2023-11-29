package com.server.tori.controller;

import com.server.tori.dto.Review.*;
import com.server.tori.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/landmarks/{landmarkId}/reviews")
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 생성
    @PostMapping
    public ReviewWriteResponseDto postReview(@PathVariable("landmarkId") Long landmarkId, @RequestBody ReviewWriteRequestDto reviewWriteRequestDto){
        return reviewService.postReview(landmarkId, reviewWriteRequestDto);
    }

    // 리뷰 조회 (+ 댓글 조회 함께)
    @GetMapping
    public List<ReviewViewResponseDto> getReviews(@PathVariable("landmarkId") Long landmarkId){
        return reviewService.getReviews();
    }

    // 리뷰 수정
    @PatchMapping("/{reviewId}")
    public ReviewEditResponseDto patchReview(@PathVariable("landmarkId") Long landmarkId, @PathVariable("reviewId") Long id, @RequestBody ReviewEditRequestDto reviewEditRequestDto){
        return reviewService.patchReview(landmarkId, id, reviewEditRequestDto);
    }

    // 리뷰 삭제
    @DeleteMapping("/{reviewId}")
    public String deleteReview(@PathVariable("landmarkId") Long landmarkId, @PathVariable("reviewId") Long id, @RequestBody ReviewDeleteRequestDto reviewDeleteRequestDto){
        return reviewService.deleteReview(landmarkId, id, reviewDeleteRequestDto);

    }
}
