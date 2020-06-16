package com.jmall.shopping.dto;

import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.tool.exception.ValidateException;
import com.jmall.shopping.constants.ShoppingRetCode;
import lombok.Data;

import java.util.List;

@Data
public class ClearCartItemRequest extends AbstractRequest {

    private Long userId;
    private List<Long> productIds;
    @Override
    public void requestCheck() {
        if(userId==null){
            throw new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
