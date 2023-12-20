package com.server.tori.service;

import com.server.tori.dto.Review.*;
import com.server.tori.entity.Dotori;
import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Review;
import com.server.tori.entity.User;
import com.server.tori.exception.CustomException;
import com.server.tori.exception.ErrorCode;
import com.server.tori.repository.DotoriRepository;
import com.server.tori.repository.LandmarkRepository;
import com.server.tori.repository.ReviewRepository;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LandmarkRepository landmarkRepository;

    @Autowired
    private DotoriRepository dotoriRepository;

    public ReviewCreateResponseDto createReview(Long landmarkId, ReviewCreateRequestDto reviewCreateRequestDto) {

        User user = getUserById(reviewCreateRequestDto.getUserId());
        Landmark landmark = getLandmarkById(landmarkId);

        Dotori dotori = dotoriRepository.save(new Dotori(user));

        Review review = reviewRepository.save(
                new Review(user, landmark, dotori,
                        reviewCreateRequestDto.getContent(), LocalDateTime.now()));

        return new ReviewCreateResponseDto(user, review);

    }

    public List<ReviewGetResponseDto> getReview(Long landmarkId) {

        Landmark landmark = getLandmarkById(landmarkId);

        List<Review> reviewList = reviewRepository.findByLandmark(landmark);

        return reviewList.stream()
                .map(review -> {
                    checkReviewInLandmark(landmarkId, review);
                    return new ReviewGetResponseDto(review, review.getUser());
                })
                .collect(Collectors.toList());

    }

    public ReviewUpdateResponseDto updateReview(Long landmarkId, Long id, ReviewUpdateRequestDto reviewUpdateRequestDto) {

        Review review = getReviewById(id);
        User user = getUserById(reviewUpdateRequestDto.getUserId());
        Landmark landmark = getLandmarkById(landmarkId);

        checkUserInReview(reviewUpdateRequestDto.getUserId(), review);
        checkReviewInLandmark(landmarkId, review);

        review.patchContent(reviewUpdateRequestDto.getContent());
        review.patchModifyDate();

        reviewRepository.save(review);

        return new ReviewUpdateResponseDto(user, review);

    }

    public String deleteReview(Long landmarkId, Long id, ReviewDeleteRequestDto reviewDeleteRequestDto) {

        Review review = getReviewById(id);
        User user = getUserById(reviewDeleteRequestDto.getUserId());
        Landmark landmark = getLandmarkById(landmarkId);

        checkUserInReview(reviewDeleteRequestDto.getUserId(), review);
        checkReviewInLandmark(landmarkId, review);

        reviewRepository.delete(review);

        return "리뷰가 성공적으로 삭제되었습니다.";

    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    }

    private Landmark getLandmarkById(Long landmarkId) {
        return landmarkRepository.findById(landmarkId)
                .orElseThrow(() -> new CustomException(ErrorCode.LANDMARK_NOT_FOUND));
    }

    private Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.REVIEW_NOT_FOUND));
    }

    // 해당 landmark에 속한 review인지 확인
    private static void checkReviewInLandmark(Long landmarkId, Review review) {
        if (!review.getLandmark().getId().equals(landmarkId)) throw new CustomException(ErrorCode.NOT_IN_LANDMARK_REVIEW);
    }

    // 해당 review에 접근 권한이 있는 user인지 확인
    private static void checkUserInReview(Long userId, Review review) {
        if (!review.getUser().getId().equals(userId)) throw new CustomException(ErrorCode.FORBIDDEN_REVIEW_USER);
    }

}