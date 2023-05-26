package com.dev.ajou.catchatgpt.common;

public class NotFoundException extends ManageableException {

    public NotFoundException(String message) {
        super(message, ErrorCode.NOT_FOUND_EXCEPTION);
    }

    public NotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

}