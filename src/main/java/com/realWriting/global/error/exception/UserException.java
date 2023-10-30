package com.realWriting.global.error.exception;

import com.realWriting.global.error.ErrorCode;

public class UserException extends AbstractBusinessLogicException {
    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
