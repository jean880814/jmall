package com.jmall.pay.dal.entitys;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "tb_refund")
@Data
public class Refund {
	@Id
	private Long id;

	@Column(name = "order_id")
	private String orderId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "trade_no")
	private String tradeNo;

	@Column(name = "refund_no")
	private String refundNo;

	private BigDecimal amount;

	private Integer status;

	@Column(name = "user_name")
	private String userName;

	private Integer channel;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "gmt_create")
	private Date gmtCreate;

}