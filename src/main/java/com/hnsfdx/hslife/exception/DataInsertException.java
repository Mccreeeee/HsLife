package com.hnsfdx.hslife.exception;

public class DataInsertException extends BaseException {
    @Override
    public ExceptionCode getExceptionCode() {
        return ExceptionCode.valueOf("DATA_INSERT_EXCEPTION");
    }
}
