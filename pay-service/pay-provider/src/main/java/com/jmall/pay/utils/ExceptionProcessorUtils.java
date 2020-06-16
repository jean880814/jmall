package com.jmall.pay.utils;

import com.jmall.commons.result.AbstractResponse;
import com.jmall.commons.tool.exception.ExceptionUtil;
import com.jmall.pay.constants.PayReturnCodeEnum;

public class ExceptionProcessorUtils {

    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionUtil.handlerException4biz(response,e);
        } catch (Exception ex) {
            response.setCode(PayReturnCodeEnum.SYSTEM_ERROR.getCode());
            response.setMsg(PayReturnCodeEnum.SYSTEM_ERROR.getMsg());
        }
    }
}
