package com.jmall.order.biz.context;

import com.jmall.order.biz.convert.TransConvert;
import lombok.Data;

@Data
public abstract class AbsTransHandlerContext implements TransHandlerContext {

    private String orderId;

    private TransConvert convert = null;


}
