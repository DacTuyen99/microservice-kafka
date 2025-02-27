package com.cdtuyen.commonServer.exception;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ErrorCode {
    private String code;
    private String defaultMessage;
    private int status;

    public ErrorCode(String code, String defaultMessage, int status){
        this.code = code;
        this.status = status;
        this.defaultMessage = defaultMessage;
    }
}
