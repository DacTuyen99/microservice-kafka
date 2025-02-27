package com.cdtuyen.commonServer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String code;
    private String service;
    private String path;
    private LocalDateTime timestamp;
    public ErrorResponse (CommonException ex){
        this.code = StringUtils.hasText(ex.getErrorCode().getCode()) ? ex.getErrorCode().getCode() : null;
        this.path = StringUtils.hasText(ex.getPath()) ? ex.getPath() : null;
        this.timestamp = LocalDateTime.now();
        this.message = !ObjectUtils.isEmpty(ex.getMessage()) ? ex.getMessage() : null;
        this.service = StringUtils.hasText(ex.getService()) ? ex.getService() : null;
    }
}
