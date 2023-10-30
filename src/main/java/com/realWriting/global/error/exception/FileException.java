package com.realWriting.global.error.exception;

import com.realWriting.global.error.ErrorCode;

public class FileException extends AbstractBusinessLogicException {
    public FileException(ErrorCode errorCode) {
        super(errorCode);
    }
}

