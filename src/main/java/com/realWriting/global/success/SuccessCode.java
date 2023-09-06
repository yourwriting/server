package com.realWriting.global.success;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum SuccessCode {
    /* Note */
    NOTE_CREATE_SUCCESS(OK, "0110", "노트 생성 성공"),
    NOTE_UPDATE_SUCCESS(OK, "0111", "노트 수정 성공"),
    NOTE_DELETE_SUCCESS(OK, "0112", "노트 삭제 성공"),
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
