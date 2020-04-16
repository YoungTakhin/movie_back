package com.ydx.movie.exception;

public class LoginException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;

    public LoginException(ErrorEnum errorEnum) {
        super(errorEnum.getErrorMassage());
        this.code = errorEnum.getErrorCode();
    }
}
