package com.hnsfdx.hslife.exception;

public enum ExceptionCode {
    DATA_INSERT_EXCEPTION(50001, "Data Insert Error"),
    DATA_UPDATE_EXCEPTION(50002, "Data Update Error"),
    DATA_DELETE_EXCEPTION(50003, "Data Delete Error"),
    ARGS_INTRODUCE_EXCEPTION(50004, "Args Introduce Error");

    private Integer code;
    private String msg;

    private ExceptionCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
