package com.jmall.shopping.dto;

import com.jmall.commons.result.AbstractRequest;
import lombok.Data;

@Data
public class AllProductRequest extends AbstractRequest {

    private Integer page;
    private Integer size;
    private String sort;
    private Long cid;
    private Integer priceGt;
    private Integer priceLte;

    @Override
    public void requestCheck() {
        if(page<=0){
            setPage(1);
        }
    }
}
