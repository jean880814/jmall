package com.jmall.shopping.dto;


import com.jmall.commons.result.AbstractRequest;
import lombok.Data;

@Data
public class AllProductCateRequest extends AbstractRequest {
    private String sort;

    @Override
    public void requestCheck() {

    }
}
