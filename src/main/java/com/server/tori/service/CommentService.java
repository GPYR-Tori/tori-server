package com.server.tori.service;

import com.server.tori.dto.Comment.*;
import com.server.tori.entity.Comment;
import com.server.tori.entity.Review;
import com.server.tori.entity.User;
import com.server.tori.exception.CustomException;
import com.server.tori.exception.ErrorCode;
import com.server.tori.repository.CommentRepository;
import com.server.tori.repository.ReviewRepository;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    public CommentPostResponseDto createComment(Long reviewId, CommentPostRequestDto commentPostRequestDto) {

        User user = getUserById(commentPostRequestDto.getUserId());
        Review review = getReviewById(reviewId);

        Comment comment = commentRepository.save(
                new Comment(user, review, commentPostRequestDto.getContent(), LocalDateTime.now()));

        return new CommentPostResponseDto(user, comment);

    }

    public CommentPatchResponseDto updateComment(Long reviewId, Long id, CommentPatchRequestDto commentPatchRequestDto) {

        Comment comment = getCommentById(id);
        User user = getUserById(commentPatchRequestDto.getUserId());
        Review review = getReviewById(reviewId);

        checkUserInComment(commentPatchRequestDto.getUserId(), comment);
        checkCommentInReview(reviewId, comment);

        comment.patchContent(commentPatchRequestDto.getContent());
        comment.patchModifyDate();

        commentRepository.save(comment);

        return new CommentPatchResponseDto(user, comment);

    }

    public String deleteComment(Long reviewId, Long id, CommentDeleteRequestDto commentDeleteRequestDto) {

        Comment comment = getCommentById(id);
        User user = getUserById(commentDeleteRequestDto.getUserId());
        Review review = getReviewById(reviewId);

        checkUserInComment(commentDeleteRequestDto.getUserId(), comment);
        checkCommentInReview(reviewId, comment);

        commentRepository.delete(comment);

        return "댓글이 성공적으로 삭제되었습니다.";

    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    }

    private Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(ErrorCode.REVIEW_NOT_FOUND));
    }

    private Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
    }

    // 해당 review에 속한 comment인지 확인
    private static void checkCommentInReview(Long reviewId, Comment comment) {
        if (!comment.getReview().getId().equals(reviewId)) throw new CustomException(ErrorCode.NOT_IN_REVIEW_COMMENT);
    }

    // 해당 comment에 접근 권한이 있는 user인지 확인
    private static void checkUserInComment(Long userId, Comment comment) {
        if (!comment.getUser().getId().equals(userId)) throw new CustomException(ErrorCode.FORBIDDEN_COMMENT_USER);
    }
}
