package com.realWriting.global.success;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Getter
public enum SuccessCode {
    /* Note */
    NOTE_CREATE_SUCCESS(CREATED, "0110", "노트 생성 성공"),
    NOTE_GET_SUCCESS(OK, "0111", "노트 조회 성공"),
    NOTE_UPDATE_SUCCESS(OK, "0112", "노트 수정 성공"),
    NOTE_DELETE_SUCCESS(OK, "0113", "노트 삭제 성공"),
    SHOW_NOTES_SUCCESS(OK, "0114", "모든 노트 조회 성공"),
    IMAGE_UPLOAD_SUCCESS(OK, "0115", "이미지 첨부 성공"),
    /* User */
    USER_SIGNUP_SUCCESS(CREATED, "0120", "회원가입 성공"),
    USER_LOGIN_SUCCESS(OK, "0121", "로그인 성공"),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    SuccessCode(final HttpStatus httpStatus, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
