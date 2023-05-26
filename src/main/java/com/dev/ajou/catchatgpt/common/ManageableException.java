package com.dev.ajou.catchatgpt.common;

public abstract class ManageableException extends RuntimeException {

    private ErrorCode errorCode;

    public ManageableException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ManageableException(String message) {
        super(message);
    }

}