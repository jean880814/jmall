package com.jmall.order.dal.persistence;

import com.jmall.commons.tool.tkmapper.TkMapper;
import com.jmall.order.dal.entitys.Order;

public interface OrderMapper extends TkMapper<Order> {
    Long countAll();
}