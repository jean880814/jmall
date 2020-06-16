package com.jmall.shopping.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class CartListByIdResponse extends AbstractResponse {

    private List<CartProductDto> cartProductDtos;
}
