package com.jmall.search.utils;

import com.jmall.commons.result.AbstractResponse;
import com.jmall.commons.tool.exception.ExceptionUtil;
import com.jmall.search.consts.SearchRetCode;

public class ExceptionProcessorUtils {

    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionUtil.handlerException4biz(response,e);
        } catch (Exception ex) {
            response.setCode(SearchRetCode.SYSTEM_ERROR.getCode());
            response.setMsg(SearchRetCode.SYSTEM_ERROR.getMsg());
        }
    }
}
