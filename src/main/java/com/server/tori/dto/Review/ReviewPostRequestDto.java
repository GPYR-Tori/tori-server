package com.server.tori.dto.Review;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReviewPostRequestDto {
    private Long userId;
    private String content;
}
