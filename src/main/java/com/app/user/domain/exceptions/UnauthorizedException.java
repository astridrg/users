package com.app.user.domain.exceptions;

public class UnauthorizedException extends  RuntimeException{

    public UnauthorizedException(String message, Throwable err) {
        super(message, err);
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
