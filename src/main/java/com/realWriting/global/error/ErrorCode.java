package com.realWriting.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum ErrorCode {
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "00001", "서버 내부 에러"),
    /* Note */
    NOTE_NOT_FOUND(BAD_REQUEST, "01101", "존재하지 않는 노트 ID"),
    /* Member */
    DUPLICATED_EMAIL(BAD_REQUEST, "01201", "이미 가입된 이메일입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ErrorCode(final HttpStatus httpStatus, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
