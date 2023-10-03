package com.realWriting.global.error.exception;

import com.realWriting.global.error.ErrorCode;

public class DuplicationException extends AbstractBusinessLogicException {
    public DuplicationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
