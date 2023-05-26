package com.dev.ajou.catchatgpt.common;


public enum ErrorCode {
    NOT_FOUND_EXCEPTION("C002", "존재하지 않습니다"),
    ;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private final String code;
    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}