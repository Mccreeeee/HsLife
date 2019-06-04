package com.hnsfdx.hslife.exception.handler;

import com.hnsfdx.hslife.exception.DataInsertException;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsHandler {
    private Map<String, Object> handler(Integer exCode, String exMsg) {
        HashMap<String,Object> res = new HashMap<>();
        res.put("result", ResponseTypeUtil.BOOLEAN_FAIL);
        res.put("code", exCode);
        res.put("timestamp", new Date());
        res.put("message", exMsg);
        res.put("data", null);
        return res;
    }
    @ExceptionHandler(DataInsertException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> insertExceptionHandler() {
        Map<String, Object> res = handler(DataInsertException.EXCEPTION_CODE, DataInsertException.EXCEPTION_MESSAGE);
        return res;
    }

}
