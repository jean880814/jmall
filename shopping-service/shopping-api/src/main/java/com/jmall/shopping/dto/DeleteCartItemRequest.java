package com.jmall.shopping.dto;

import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.tool.exception.ValidateException;
import com.jmall.shopping.constants.ShoppingRetCode;
import lombok.Data;

@Data
public class DeleteCartItemRequest extends AbstractRequest {
    private Long userId;
    private Long itemId;

    @Override
    public void requestCheck() {
        if(userId==null||itemId==null){
            throw new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
