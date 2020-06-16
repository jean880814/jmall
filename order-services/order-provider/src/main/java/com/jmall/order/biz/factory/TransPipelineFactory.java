package com.jmall.order.biz.factory;

import com.jmall.order.biz.TransOutboundInvoker;

public interface TransPipelineFactory<T> {

    TransOutboundInvoker build(T obj);
}
