package com.jmall.user.utils;


import com.jmall.commons.result.AbstractResponse;
import com.jmall.commons.tool.exception.ExceptionUtil;
import com.jmall.user.constants.SysRetCodeConstants;

public class ExceptionProcessorUtils {

    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionUtil.handlerException4biz(response,e);
        } catch (Exception ex) {
            response.setCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            response.setMsg(SysRetCodeConstants.SYSTEM_ERROR.getMessage());
        }
    }
}
