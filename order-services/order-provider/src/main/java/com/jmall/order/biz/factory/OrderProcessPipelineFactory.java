package com.jmall.order.biz.factory;

import com.jmall.order.biz.context.CreateOrderContext;
import com.jmall.order.biz.context.TransHandlerContext;
import com.jmall.order.biz.convert.CreateOrderConvert;
import com.jmall.order.biz.convert.TransConvert;
import com.jmall.order.biz.handler.*;
import com.jmall.order.dto.CreateOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderProcessPipelineFactory extends AbstranctTransPipelineFactory<CreateOrderRequest> {

    @Autowired
    private InitOrderHandler initOrderHandler;
    @Autowired
    private ValidateHandler validateHandler;
    @Autowired
    private LogisticalHandler logisticalHandler;
    @Autowired
    private ClearCartItemHandler clearCartItemHandler;
    @Autowired
    private SubStockHandler subStockHandler;
    @Autowired
    private SendMessageHandler sendMessageHandler;


    @Override
    protected TransHandlerContext createContext() {
        CreateOrderContext createOrderContext=new CreateOrderContext();
        return createOrderContext;
    }

    @Override
    protected void doBuild(TransPipeline pipeline) {
        pipeline.addLast(validateHandler);
        pipeline.addLast(initOrderHandler);
        pipeline.addLast(subStockHandler);
        pipeline.addLast(logisticalHandler);
        pipeline.addLast(clearCartItemHandler);
        pipeline.addLast(sendMessageHandler);
    }

    @Override
    protected TransConvert createConvert() { //构建转换器
        return new CreateOrderConvert();
    }
}
