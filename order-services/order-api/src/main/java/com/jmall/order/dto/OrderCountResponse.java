package com.jmall.order.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

@Data
public class OrderCountResponse extends AbstractResponse {

    private int count;
}
