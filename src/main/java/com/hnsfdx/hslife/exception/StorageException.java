package com.hnsfdx.hslife.exception;

public class StorageException extends BaseException {

    @Override
    public ExceptionCode getExceptionCode() {
        return ExceptionCode.valueOf("FILE_STORAGE_EXCEPTION");
    }
}
