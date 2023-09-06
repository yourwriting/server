package com.realWriting.global.error.exception;

import com.realWriting.global.error.ErrorCode;

public abstract class AbstractBusinessLogicException extends AbstractErrorException {
    public AbstractBusinessLogicException(ErrorCode errorCode) {
        super(errorCode);
    }
}