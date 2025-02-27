package com.cdtuyen.commonServer.exception.item;

import com.cdtuyen.commonServer.exception.CommonException;
import com.cdtuyen.commonServer.exception.ErrorCode;

public class DataNotFoundException extends CommonException {
    public DataNotFoundException(ErrorCode errorCode, String path, String service){
        super(errorCode, path, service);
    }
}
