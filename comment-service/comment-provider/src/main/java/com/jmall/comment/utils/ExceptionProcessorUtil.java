package com.jmall.comment.utils;


import com.jmall.comment.constant.CommentRetCode;
import com.jmall.commons.result.AbstractResponse;
import com.jmall.commons.tool.exception.ExceptionUtil;

public class ExceptionProcessorUtil {

    private ExceptionProcessorUtil() {}

    public static void handleException(AbstractResponse response, Exception e) {
        try {
            ExceptionUtil.handlerException4biz(response, e);
        } catch (Exception ex) {
            response.setCode(CommentRetCode.SYSTEM_ERROR.getCode());
            response.setMsg(CommentRetCode.SYSTEM_ERROR.getMessage());
        }
    }
}
