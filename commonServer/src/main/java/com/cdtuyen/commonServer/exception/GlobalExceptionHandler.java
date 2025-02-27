package com.cdtuyen.commonServer.exception;

import com.cdtuyen.commonServer.exception.item.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(DataNotFoundException ex){
        ErrorResponse errorResponse = makeErrorResponse(ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    private ErrorResponse makeErrorResponse(CommonException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ex.getErrorCode().getCode());
        errorResponse.setMessage(ex.getErrorCode().getDefaultMessage());
        errorResponse.setService(ex.getService());
        errorResponse.setTimestamp(LocalDateTime.now());
        return errorResponse;
    }
}
