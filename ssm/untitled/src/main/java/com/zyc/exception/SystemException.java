package com.zyc.exception;

import com.zyc.controller.code.StatusCode;

public class SystemException extends RuntimeException {
    private final StatusCode code;

    public StatusCode getCode() {
        return code;
    }

    public SystemException(StatusCode code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(StatusCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
