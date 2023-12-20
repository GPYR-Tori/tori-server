package com.server.tori.dto.Review;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.tori.entity.Review;
import com.server.tori.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ReviewPostResponseDto {
    private Long reviewId;
    private Long userId;
    private String nickname;
    private String nation;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;

    public ReviewPostResponseDto(User user, Review review) {
        this.reviewId = review.getId();
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.nation = user.getNation();
        this.content = review.getContent();
        this.createDate = review.getCreateDate();
    }
}