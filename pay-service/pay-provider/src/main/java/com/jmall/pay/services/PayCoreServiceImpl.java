package com.jmall.pay.services;

import com.alibaba.fastjson.JSON;
import com.jmall.pay.biz.abs.BasePayment;
import com.jmall.pay.utils.ExceptionProcessorUtils;
import com.jmall.pay.PayCoreService;
import com.jmall.pay.dto.*;
import com.jmall.pay.dto.PaymentNotifyRequest;
import com.jmall.pay.dto.PaymentNotifyResponse;
import com.jmall.pay.dto.PaymentRequest;
import com.jmall.pay.dto.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service(cluster = "failover")
public class PayCoreServiceImpl implements PayCoreService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PaymentResponse execPay(PaymentRequest request) {

        PaymentResponse paymentResponse=new PaymentResponse();
        try {
            paymentResponse= BasePayment.paymentMap.get(request.getPayChannel()).process(request);
        }catch (Exception e){
            log.error("PayCoreServiceImpl.execPay Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(paymentResponse,e);
        }
        return paymentResponse;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PaymentNotifyResponse paymentResultNotify(PaymentNotifyRequest request) {
        log.info("paymentResultNotify request:{}", JSON.toJSONString(request));
        PaymentNotifyResponse response=new PaymentNotifyResponse();
        try{
            response=BasePayment.paymentMap.get
                    (request.getPayChannel()).completePayment(request);

        }catch (Exception e){
            log.error("paymentResultNotify occur exception:"+e);
            ExceptionProcessorUtils.wrapperHandlerException(response,e);
        }finally {
            log.info("paymentResultNotify return result:{}",JSON.toJSONString(response));
        }
        return response;
    }

    /**
     * 执行退款
     * @param refundRequest
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RefundResponse execRefund(RefundRequest refundRequest) {
        RefundResponse refundResponse=new RefundResponse();
        try {
            refundResponse=BasePayment.paymentMap.get(refundRequest.getPayChannel()).process(refundRequest);
        }catch (Exception e){
            log.error("PayCoreServiceImpl.execRefund Occur Exception :{}",e);
            ExceptionProcessorUtils.wrapperHandlerException(refundResponse,e);
        }
        return refundResponse;
    }
}
