package com.server.tori.dto.Review;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReviewUpdateRequestDto {
    private Long userId;
    private String content;
}
