package com.server.tori.dto.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentWriteRequestDto {
    private Long userId;
    private String content;
}
