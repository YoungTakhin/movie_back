package com.ydx.movie.exception;

public enum ErrorEnum {
    E_1(1, "用户名或密码错误"),

    ;

    private Integer errorCode;
    private String errorMassage;

    ErrorEnum(Integer errorCode, String errorMassage) {
        this.errorCode = errorCode;
        this.errorMassage = errorMassage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMassage() {
        return errorMassage;
    }
}
