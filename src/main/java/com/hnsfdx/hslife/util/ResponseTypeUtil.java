package com.hnsfdx.hslife.util;

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
    public static Map<String,Object> createSucResponse(){
        HashMap<String,Object> forRet = new HashMap<>();
        forRet.put("result",BOOLEAN_SUC);
        return forRet;
    }
}