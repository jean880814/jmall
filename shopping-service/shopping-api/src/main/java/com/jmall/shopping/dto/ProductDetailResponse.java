package com.jmall.shopping.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;


@Data
public class ProductDetailResponse extends AbstractResponse {
    private ProductDetailDto productDetailDto;
}
