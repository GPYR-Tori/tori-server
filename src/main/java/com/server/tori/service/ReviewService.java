package com.server.tori.service;

import com.server.tori.dto.Review.*;
import com.server.tori.entity.Dotori;
import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Review;
import com.server.tori.entity.User;
import com.server.tori.repository.DotoriRepository;
import com.server.tori.repository.LandmarkRepository;
import com.server.tori.repository.ReviewRepository;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

    public ReviewWriteResponseDto postReview(Long landmarkId, ReviewWriteRequestDto reviewWriteRequestDto) {
        Optional<User> userOptional = userRepository.findById(reviewWriteRequestDto.getUserId());
        Optional<Landmark> landmarkOptional = landmarkRepository.findById(landmarkId);

        if (userOptional.isPresent() && landmarkOptional.isPresent()) {
            User selectedUser = userOptional.get();
            Landmark selectedLandmark = landmarkOptional.get();

            Dotori dotori = new Dotori(selectedUser);
            dotoriRepository.save(dotori);

            Review review = new Review(selectedUser, selectedLandmark, dotori, reviewWriteRequestDto.getContent(), LocalDateTime.now());
            Review savedReview = reviewRepository.save(review);

            return new ReviewWriteResponseDto(selectedUser, savedReview);
        }
        return null;
    }

    public List<ReviewViewResponseDto> getReviews() {
        List<Review> reviewsList = reviewRepository.findAll();

        return reviewsList.stream()
                .map(review -> new ReviewViewResponseDto(review, review.getUser()))
                .collect(Collectors.toList());
    }

    public ReviewEditResponseDto patchReview(Long landmarkId, Long id, ReviewEditRequestDto reviewEditRequestDto) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        Optional<User> userOptional = userRepository.findById(reviewEditRequestDto.getUserId());
        Optional<Landmark> landmarkOptional = landmarkRepository.findById(landmarkId);

        if (reviewOptional.isPresent() && userOptional.isPresent() && landmarkOptional.isPresent()) {
            Review review = reviewOptional.get();
            User selectedUser = userOptional.get();

            review.patchContent(reviewEditRequestDto.getContent());
            review.patchModifyDate();

            Review afterReview = reviewRepository.save(review);

            return new ReviewEditResponseDto(selectedUser, afterReview);
        }
        return null;
    }

    public String deleteReview(Long landmarkId, Long id, ReviewDeleteRequestDto reviewDeleteRequestDto) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        Optional<User> userOptional = userRepository.findById(reviewDeleteRequestDto.getUserId());
        Optional<Landmark> landmarkOptional = landmarkRepository.findById(landmarkId);

        if (reviewOptional.isPresent() && userOptional.isPresent() && landmarkOptional.isPresent()) {
            Review review = reviewOptional.get();

            reviewRepository.delete(review);

            return "success";
        }
        return "fail";
    }
}