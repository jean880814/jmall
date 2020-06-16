package com.jmall.order.biz.handler;

import com.jmall.commons.tool.exception.BizException;
import com.jmall.commons.tool.utils.NumberUtils;
import com.jmall.order.biz.callback.SendEmailCallback;
import com.jmall.order.biz.callback.TransCallback;
import com.jmall.order.biz.context.CreateOrderContext;
import com.jmall.order.biz.context.TransHandlerContext;
import com.jmall.order.constant.OrderRetCode;
import com.jmall.order.constants.OrderConstants;
import com.jmall.order.dal.entitys.Order;
import com.jmall.order.dal.entitys.OrderItem;
import com.jmall.order.dal.persistence.OrderItemMapper;
import com.jmall.order.dal.persistence.OrderMapper;
import com.jmall.order.utils.GlobalIdGeneratorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@Component
public class InitOrderHandler extends AbstractTransHandler {

    @Autowired
    SendEmailCallback sendEmailCallback;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    GlobalIdGeneratorUtil globalIdGeneratorUtil;

    private final String ORDER_GLOBAL_ID_CACHE_KEY="ORDER_ID";
    private final String ORDER_ITEM_GLOBAL_ID_CACHE_KEY="ORDER_ITEM_ID";
    @Override
    public TransCallback getTransCallback() {
        return sendEmailCallback;
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    //TODO: 事务这里还没测试过， 大家看到这段代码的时候测试一下，如果有问题记得改
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public boolean handle(TransHandlerContext context) {
        log.info("begin InitOrderHandler :context:"+context);
        Order order=new Order();
        try {
            CreateOrderContext createOrderContext=(CreateOrderContext)context;
            String orderId = globalIdGeneratorUtil.getNextSeq(ORDER_GLOBAL_ID_CACHE_KEY, 1);
            order.setOrderId(orderId);
            order.setUserId(Long.valueOf(createOrderContext.getUserId()));
            order.setBuyerNick(createOrderContext.getBuyerNickName());
            order.setPayment(createOrderContext.getOrderTotal());
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            order.setStatus(OrderConstants.ORDER_STATUS_INIT);
            orderMapper.insert(order); //保存订单
            List<Long> buyProductIds=new ArrayList<>();
            createOrderContext.getCartProductDtoList().parallelStream().forEach(cartProductDto -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(globalIdGeneratorUtil.getNextSeq(ORDER_ITEM_GLOBAL_ID_CACHE_KEY, 1));
                orderItem.setItemId(cartProductDto.getProductId());
                orderItem.setOrderId(String.valueOf(orderId));
                orderItem.setNum(Math.toIntExact(cartProductDto.getProductNum()));
                orderItem.setPrice(NumberUtils.toDouble(cartProductDto.getSalePrice()));
                orderItem.setTitle(cartProductDto.getProductName());
                orderItem.setPicPath(cartProductDto.getProductImg());
                orderItem.setTotalFee(cartProductDto.getSalePrice().multiply(BigDecimal.valueOf(cartProductDto.getProductNum())).doubleValue());
                buyProductIds.add(cartProductDto.getProductId());
                //已锁定库存
                orderItem.setStatus(1);
                orderItemMapper.insert(orderItem);
            });
            createOrderContext.setOrderId(orderId);
            createOrderContext.setBuyProductIds(buyProductIds);
        }catch(DuplicateKeyException e){
            log.error("订单重复提交："+e);
            throw new BizException(OrderRetCode.DB_SAVE_EXCEPTION.getCode(),OrderRetCode.DB_SAVE_EXCEPTION.getMessage());
        }catch (Exception e){
            log.error("InitOrderHandler occur Exception :"+e);
            throw new BizException(OrderRetCode.DB_SAVE_EXCEPTION.getCode(),OrderRetCode.DB_SAVE_EXCEPTION.getMessage());
        }
        return true;
    }
}
