package com.jmall.pay.biz.abs;

import com.jmall.pay.dto.PaymentNotifyRequest;
import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.result.AbstractResponse;
import com.jmall.commons.tool.exception.BizException;

public interface Payment {

    /**
     * 发起交易执行的过程
     * @param request
     * @return
     * @throws BizException
     */
    <T extends AbstractResponse> T process(AbstractRequest request) throws BizException;

    /**
     * 完成交易结果的处理
     * @param request
     * @return
     * @throws BizException
     */
    <T extends AbstractResponse> T completePayment(PaymentNotifyRequest request) throws BizException;
}
