package com.jmall.pay.biz.payment.validator;

import com.jmall.commons.result.AbstractRequest;
import com.jmall.order.OrderQueryService;
import com.jmall.pay.biz.abs.BaseValidator;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service("aliPaymentValidator")
public class AliPaymentValidator extends BaseValidator {
	@Reference(timeout = 3000)
	OrderQueryService orderQueryService;

	@Override
	public void specialValidate(AbstractRequest request) {
       super.commonValidate(request,orderQueryService);
	}
}
