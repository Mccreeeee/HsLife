package com.hnsfdx.hslife.exception;

public class ArgsIntroduceException extends BaseException {
    @Override
    public ExceptionCode getExceptionCode() {
        return ExceptionCode.valueOf("ARGS_INTRODUCE_EXCEPTION");
    }
}
