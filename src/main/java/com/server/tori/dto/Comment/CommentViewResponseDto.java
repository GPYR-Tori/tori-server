package com.server.tori.dto.Comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.tori.entity.Comment;
import com.server.tori.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
public class CommentViewResponseDto {
    private Long id;
    private Long userId;
    private String nickname;
    private String nation;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;

    public CommentViewResponseDto(Comment comment, User user) {

        this.id = comment.getId();
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.nation = user.getNation();
        this.content = comment.getContent();
        this.createDate = comment.getCreateDate();
    }
}
