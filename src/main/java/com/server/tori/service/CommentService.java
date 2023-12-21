package com.server.tori.service;

import com.server.tori.dto.Comment.*;
import com.server.tori.entity.Comment;
import com.server.tori.entity.Review;
import com.server.tori.entity.User;
import com.server.tori.repository.CommentRepository;
import com.server.tori.repository.ReviewRepository;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    public CommentPostResponseDto createComment(Long reviewId, CommentPostRequestDto commentPostRequestDto) {
        Optional<User> userOptional = userRepository.findById(commentPostRequestDto.getUserId());
        Optional<Review> ReviewOptional = reviewRepository.findById(reviewId);

        if (userOptional.isPresent() && ReviewOptional.isPresent()) {
            User selectedUser = userOptional.get();
            Review selectedReview = ReviewOptional.get();

            Comment comment = new Comment(selectedUser, selectedReview, commentPostRequestDto.getContent(), LocalDateTime.now());
            Comment savedComment = commentRepository.save(comment);

            return new CommentPostResponseDto(selectedUser, savedComment);
        }
        return null;
    }

    public CommentPatchResponseDto updateComment(Long reviewId, Long id, CommentPatchRequestDto commentPatchRequestDto) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        Optional<User> userOptional = userRepository.findById(commentPatchRequestDto.getUserId());
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);

        if (commentOptional.isPresent() && userOptional.isPresent() && reviewOptional.isPresent()) {
            Comment comment = commentOptional.get();
            User selectedUser = userOptional.get();

            comment.patchContent(commentPatchRequestDto.getContent());
            comment.patchModifyDate();

            Comment afterComment = commentRepository.save(comment);

            return new CommentPatchResponseDto(selectedUser, afterComment);
        }
        return null;
    }

    public String deleteComment(Long reviewId, Long id, CommentDeleteRequestDto commentDeleteRequestDto) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        Optional<User> userOptional = userRepository.findById(commentDeleteRequestDto.getUserId());
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);

        if (commentOptional.isPresent() && userOptional.isPresent() && reviewOptional.isPresent()) {
            Comment comment = commentOptional.get();

            commentRepository.delete(comment);

            return "success";
        }
        return "fail";
    }
}
