package com.server.tori.dto.Review;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.tori.dto.Comment.CommentViewResponseDto;
import com.server.tori.entity.Comment;
import com.server.tori.entity.Review;
import com.server.tori.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class ReviewViewResponseDto {
    private Long id;
    private Long userId;
    private String nickname;
    private String nation;
    private String content;
    private List<CommentViewResponseDto> commentList;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;


    public ReviewViewResponseDto(Review review, User user) {
        this.id = review.getId();
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.nation = user.getNation();
        this.content = review.getContent();
        this.commentList = CommentViewResponseDtoList(review.getCommentList());
        this.createDate = review.getCreateDate();
    }

    private List<CommentViewResponseDto> CommentViewResponseDtoList(List<Comment> commentList) {
        return commentList.stream()
                .map(comment-> new CommentViewResponseDto(comment, comment.getUser()))
                .collect(Collectors.toList());
    }
}
