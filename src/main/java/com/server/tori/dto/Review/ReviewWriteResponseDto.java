package com.server.tori.dto.Review;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.tori.entity.Review;
import com.server.tori.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ReviewWriteResponseDto {
    private Long id;
    private Long userId;
    private String nickname;
    private String nation;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;

    public ReviewWriteResponseDto(User user, Review review) {
        this.id = review.getId();
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.nation = user.getNation();
        this.content = review.getContent();
        this.createDate = review.getCreateDate();
    }
}