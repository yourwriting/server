package com.realWriting.global.error.exception;

import com.realWriting.global.error.ErrorCode;

public class NoteException extends AbstractBusinessLogicException {
    public NoteException(ErrorCode errorCode) {
        super(errorCode);
    }
}
