package com.hnsfdx.hslife.util;

import com.hnsfdx.hslife.exception.DataInsertException;

import java.util.HashMap;
import java.util.Map;

public class ResponseTypeUtil {
    public static String BOOLEAN_SUC="success";
    public static String BOOLEAN_FAIL="fail";
    public static Map<String,Object> createFailResponse(){
        HashMap<String,Object> forRet = new HashMap<>();
        forRet.put("result",BOOLEAN_FAIL);
        return forRet;
    }
    public static Map<String,Object> createFailResponse(String msg){
        Map<String,Object> forRet = createFailResponse();
        forRet.put("msg",msg);
        return forRet;
    }
    public static Map<String,Object> createSucResponse(){
        HashMap<String,Object> forRet = new HashMap<>();
        forRet.put("result",BOOLEAN_SUC);
        return forRet;
    }
    public static Map<String,Object> createDataOpResponse(Integer result, Integer id, Exception ex) throws Exception {
        HashMap<String,Object> forRet = new HashMap<>();
        forRet.put("result",BOOLEAN_SUC);
        if(result == 0){
            throw ex;
        }
        forRet.put("data", id);
        return forRet;
    }

    public static Map<String,Object> modDataOpResponse(Integer result, Exception ex) throws Exception {
        HashMap<String,Object> forRet = new HashMap<>();
        forRet.put("result",BOOLEAN_SUC);
        if(result == 0){
            throw ex;
        }
        return forRet;
    }

    public static Map<String,Object> createSucResponseWithData(Object data){
        Map<String,Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data",data);
        return forRet;
    }
}
