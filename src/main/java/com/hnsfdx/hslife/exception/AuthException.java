package com.hnsfdx.hslife.exception;

public class AuthException extends BaseException {
    @Override
    public ExceptionCode getExceptionCode() {
        return ExceptionCode.valueOf("AUTH_EXCEPTION");
    }
}
