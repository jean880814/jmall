package com.jmall.order.dto;

import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.tool.exception.ValidateException;
import com.jmall.order.constant.OrderRetCode;
import lombok.Data;

@Data
public class OrderCountRequest extends AbstractRequest {

    private Long userId;

    @Override
    public void requestCheck() {
        if(userId==null){
            throw new ValidateException(OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
