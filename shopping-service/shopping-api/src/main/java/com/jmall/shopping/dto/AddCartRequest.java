package com.jmall.shopping.dto;

import com.jmall.commons.result.AbstractRequest;
import lombok.Data;

@Data
public class AddCartRequest extends AbstractRequest {

    private Long userId;
    private Long itemId;
    private Integer num;

    @Override
    public void requestCheck() {

    }
}
