package com.hnsfdx.hslife.exception;

public abstract class BaseException extends RuntimeException {
    public abstract ExceptionCode getExceptionCode();
}
