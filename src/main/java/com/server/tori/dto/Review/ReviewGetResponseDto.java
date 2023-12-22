package com.server.tori.dto.Review;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.tori.dto.Comment.CommentGetResponseDto;
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
public class ReviewGetResponseDto {
    private Long reviewId;
    private Long userId;
    private String nickname;
    private String nation;
    private String content;
    private List<CommentGetResponseDto> commentList;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;


    public ReviewGetResponseDto(Review review, User user) {
        this.reviewId = review.getId();
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.nation = user.getNation();
        this.content = review.getContent();
        this.commentList = CommentGetResponseDtoList(review.getCommentList());
        this.createDate = review.getCreateDate();
    }

    private List<CommentGetResponseDto> CommentGetResponseDtoList(List<Comment> commentList) {
        return commentList.stream()
                .map(comment-> new CommentGetResponseDto(comment, comment.getUser()))
                .collect(Collectors.toList());
    }
}
