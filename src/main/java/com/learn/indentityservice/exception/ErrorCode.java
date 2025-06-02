package com.learn.indentityservice.exception;

public enum ErrorCode {
    USER_EXISTED(1001,"user already existed"),
    INVALID_KEY(1004,"invalid key"),
    USERNAME_UNVALID(1002,"username must be at least 3 characters"),
    PASSWORD_UNVALID(1003,"password must be at least 8 characters"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
