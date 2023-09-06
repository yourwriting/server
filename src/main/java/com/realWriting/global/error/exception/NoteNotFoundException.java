package com.realWriting.global.error.exception;

import com.realWriting.global.error.ErrorCode;

public class NoteNotFoundException extends AbstractBusinessLogicException {
    public NoteNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
