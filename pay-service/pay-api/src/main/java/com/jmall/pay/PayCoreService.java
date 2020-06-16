package com.jmall.pay;

import com.jmall.pay.dto.*;

public interface PayCoreService {


    /**
     * 执行支付操作
     * @param request
     * @return
     */
    PaymentResponse execPay(PaymentRequest request);


    /**
     * 支付、退款结果通知处理(等待微信或者支付宝异步通知支付结果）
     * @param request
     * @return
     */
    PaymentNotifyResponse paymentResultNotify(PaymentNotifyRequest request);

    /**
     * 执行退款
     * @param refundRequest
     * @return
     */
    RefundResponse execRefund(RefundRequest refundRequest);

}
