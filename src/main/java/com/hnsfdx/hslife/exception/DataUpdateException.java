package com.hnsfdx.hslife.exception;

public class DataUpdateException extends BaseException {
    @Override
    public ExceptionCode getExceptionCode() {
        return ExceptionCode.valueOf("DATA_UPDATE_EXCEPTION");
    }
}
