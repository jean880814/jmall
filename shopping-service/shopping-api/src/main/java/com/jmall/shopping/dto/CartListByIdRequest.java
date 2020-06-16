package com.jmall.shopping.dto;

import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.tool.exception.ValidateException;
import com.jmall.shopping.constants.ShoppingRetCode;
import lombok.Data;

@Data
public class CartListByIdRequest extends AbstractRequest {
    private Long userId;
    @Override
    public void requestCheck() {
        if(userId==null||userId.intValue()==0){
            throw new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
