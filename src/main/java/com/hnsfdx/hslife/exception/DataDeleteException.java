package com.hnsfdx.hslife.exception;

public class DataDeleteException extends BaseException {
    @Override
    public ExceptionCode getExceptionCode() {
        return ExceptionCode.valueOf("DATA_DELETE_EXCEPTION");
    }
}
