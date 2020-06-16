package com.jmall.shopping.dto;


import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class AllProductCateResponse extends AbstractResponse {
    private List<ProductCateDto> productCateDtoList;
}
