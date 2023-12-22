package com.server.tori.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // 400 BAD_REQUEST: 잘못된 요청


    // 401 UNAUTHORIZED: 인증되지 않은 사용자


    // 403 FORBIDDEN: 접근 권한이 없는 사용자
    FORBIDDEN_REVIEW_USER(FORBIDDEN, "리뷰 권한이 없는 사용자입니다."),
    FORBIDDEN_COMMENT_USER(FORBIDDEN, "댓글 권한이 없는 사용자입니다."),
    NOT_IN_LANDMARK_REVIEW(FORBIDDEN, "해당 여행지에 속한 후기글이 아닙니다."),
    NOT_IN_REVIEW_COMMENT(FORBIDDEN, "해당 리뷰에 속한 댓글이 아닙니다."),

    // 404 NOT_FOUND: 잘못된 리소스 접근
    MEMBER_NOT_FOUND(NOT_FOUND, "해당 회원 정보를 찾을 수 없습니다."),
    LANDMARK_NOT_FOUND(NOT_FOUND, "해당 여행지 정보를 찾을 수 없습니다."),
    REVIEW_NOT_FOUND(NOT_FOUND, "해당 리뷰를 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(NOT_FOUND, "해당 댓글을 찾을 수 없습니다."),

    // 409 CONFLICT: 중복된 리소스


    // 500 INTERNAL SERVER ERROR
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "내부 서버 에러입니다.");


    private final HttpStatus httpStatus;
    private final String message;

}
