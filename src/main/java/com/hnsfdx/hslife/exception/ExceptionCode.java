package com.hnsfdx.hslife.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionCode {
    DATA_INSERT_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, 50001, "Data Insert Error"),
    DATA_UPDATE_EXCEPTION(HttpStatus.NOT_FOUND, 50002, "Data Update Error"),
    DATA_DELETE_EXCEPTION(HttpStatus.NOT_FOUND, 50003, "Data Delete Error"),
    ARGS_INTRODUCE_EXCEPTION(HttpStatus.BAD_REQUEST, 50004, "Args Introduce Error");

    private HttpStatus status;
    private Integer code;
    private String msg;

    private ExceptionCode(HttpStatus status, Integer code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
