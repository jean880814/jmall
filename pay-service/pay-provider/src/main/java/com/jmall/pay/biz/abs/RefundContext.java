package com.jmall.pay.biz.abs;

import lombok.Data;

@Data
public class RefundContext extends Context{
	/** 商城退款流水号*/
	private String refundPlatformNo;
	/**用户id**/
	private Long userId;

}