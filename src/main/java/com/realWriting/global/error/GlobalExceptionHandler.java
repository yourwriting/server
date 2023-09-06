package com.realWriting.global.error;

import com.realWriting.global.error.exception.AbstractBusinessLogicException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AbstractBusinessLogicException.class)
    public ResponseEntity<ErrorResponse> handleBusinessLogicException(AbstractBusinessLogicException e) {
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getCode(), e.getMessage());
        return new ResponseEntity<>(errorResponse, errorCode.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorCode errorCode = ErrorCode.SERVER_ERROR;
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getCode(), e.getMessage());
        return new ResponseEntity<>(errorResponse, errorCode.getHttpStatus());
    }
}
