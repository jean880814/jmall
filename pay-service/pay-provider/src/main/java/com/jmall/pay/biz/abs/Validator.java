package com.jmall.pay.biz.abs;


import com.jmall.commons.result.AbstractRequest;

public interface Validator {
    /**
     * 数据验证
     * @param request
     */
    void validate(AbstractRequest request);
}
