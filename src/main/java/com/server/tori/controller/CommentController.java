package com.server.tori.controller;

import com.server.tori.dto.Comment.*;
import com.server.tori.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reviews/{reviewId}/comments")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글 생성
    @PostMapping
    public CommentPostResponseDto createComment(@PathVariable("reviewId") Long reviewId, @RequestBody CommentPostRequestDto commentPostRequestDto){
        return commentService.createComment(reviewId, commentPostRequestDto);
    }

    // 댓글 수정
    @PatchMapping("/{commentId}")
    public CommentPatchResponseDto updateComment(@PathVariable("reviewId") Long reviewId, @PathVariable("commentId") Long id, @RequestBody CommentPatchRequestDto commentPatchRequestDto){
        return commentService.updateComment(reviewId, id, commentPatchRequestDto);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable("reviewId") Long reviewId, @PathVariable("commentId") Long id, @RequestBody CommentDeleteRequestDto commentDeleteRequestDto){
        return commentService.deleteComment(reviewId, id, commentDeleteRequestDto);
    }
}