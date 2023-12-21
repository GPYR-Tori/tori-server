package com.server.tori.dto.Comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.tori.entity.Comment;
import com.server.tori.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CommentPatchResponseDto {
    private Long userId;
    private String nickname;
    private String nation;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime modifyDate;

    public CommentPatchResponseDto(User user, Comment comment) {
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.nation = user.getNation();
        this.content = comment.getContent();
        this.modifyDate = comment.getModifyDate();
    }
}