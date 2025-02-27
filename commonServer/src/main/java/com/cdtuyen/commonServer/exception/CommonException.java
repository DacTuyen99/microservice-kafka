package com.cdtuyen.commonServer.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class CommonException extends RuntimeException {
    private static final String KEY_EXT_MESSAGE = "message";

    private ErrorCode errorCode;
    private String path;
    private String service;
    public CommonException(ErrorCode errorCode, String path, String service){
        super(errorCode.getDefaultMessage());
        this.errorCode = errorCode;
        this.path = path;
        this.service = service;
    }
}
