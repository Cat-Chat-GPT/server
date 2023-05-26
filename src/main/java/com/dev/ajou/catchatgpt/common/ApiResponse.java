package com.dev.ajou.catchatgpt.common;


public class ApiResponse<T> {
    public ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static final ApiResponse<String> SUCCESS = success("");

    private String code;

    private String message;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("", "", data);
    }
    public static ApiResponse<Object> error(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getCode(), errorCode.getMessage(), null);
    }
    public static ApiResponse<Object> error(ErrorCode errorCode, String message) {
        return new ApiResponse<>(errorCode.getCode(), message, null);
    }
}