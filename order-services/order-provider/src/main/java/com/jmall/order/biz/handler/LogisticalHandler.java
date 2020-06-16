package com.jmall.order.biz.handler;
import com.jmall.commons.tool.exception.BizException;
import com.jmall.order.biz.context.CreateOrderContext;
import com.jmall.order.biz.context.TransHandlerContext;
import com.jmall.order.constant.OrderRetCode;
import com.jmall.order.dal.entitys.OrderShipping;
import com.jmall.order.dal.persistence.OrderShippingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class LogisticalHandler extends AbstractTransHandler {

    @Autowired
    OrderShippingMapper orderShippingMapper;

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean handle(TransHandlerContext context) {
        log.info("begin LogisticalHandler :context:"+context);
        try {
            CreateOrderContext createOrderContext=(CreateOrderContext)context;
            OrderShipping orderShipping = new OrderShipping();
            orderShipping.setOrderId(String.valueOf(createOrderContext.getOrderId()));
            orderShipping.setReceiverName(createOrderContext.getUserName());
            orderShipping.setReceiverAddress(createOrderContext.getStreetName());
            orderShipping.setReceiverPhone(createOrderContext.getTel());
            orderShipping.setCreated(new Date());
            orderShipping.setUpdated(new Date());
            orderShippingMapper.insert(orderShipping);
        }catch (Exception e){
            throw new BizException(OrderRetCode.SHIPPING_DB_SAVED_FAILED.getCode(),OrderRetCode.SHIPPING_DB_SAVED_FAILED.getMessage());
        }
        return true;
    }
}
