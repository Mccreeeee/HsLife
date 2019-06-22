package com.hnsfdx.hslife.exception.handler;

import com.hnsfdx.hslife.exception.DataDeleteException;
import com.hnsfdx.hslife.exception.DataInsertException;
import com.hnsfdx.hslife.exception.DataUpdateException;
import com.hnsfdx.hslife.exception.DataExceptionCode;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsHandler {
    private static final ThreadLocal<DateFormat> dateThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    private Map<String, Object> handler(Integer exCode, String exMsg) {
        HashMap<String,Object> res = new HashMap<>();
        res.put("result", ResponseTypeUtil.BOOLEAN_FAIL);
        res.put("code", exCode);
        res.put("timestamp", dateThreadLocal.get().format(new Date()));
        res.put("message", exMsg);
        res.put("data", null);
        return res;
    }
    @ExceptionHandler(DataInsertException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> insertExceptionHandler() {
        DataExceptionCode dataExceptionCode = DataExceptionCode.valueOf("DATA_INSERT_EXCEPTION");
        Map<String, Object> res = handler(dataExceptionCode.getCode(), dataExceptionCode.getMsg());
        return res;
    }

    @ExceptionHandler(DataUpdateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Map<String, Object> updateExceptionHandler() {
        DataExceptionCode dataExceptionCode = DataExceptionCode.valueOf("DATA_UPDATE_EXCEPTION");
        Map<String, Object> res = handler(dataExceptionCode.getCode(), dataExceptionCode.getMsg());
        return res;
    }

    @ExceptionHandler(DataDeleteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Map<String, Object> deleteExceptionHandler() {
        DataExceptionCode dataExceptionCode = DataExceptionCode.valueOf("DATA_DELETE_EXCEPTION");
        Map<String, Object> res = handler(dataExceptionCode.getCode(), dataExceptionCode.getMsg());
        return res;
    }

}
