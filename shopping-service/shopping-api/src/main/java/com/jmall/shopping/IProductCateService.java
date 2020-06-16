package com.jmall.shopping;

import com.jmall.shopping.dto.AllProductCateRequest;
import com.jmall.shopping.dto.AllProductCateResponse;

public interface IProductCateService {
    /**
     * 获取所有产品分类
     * @param request
     * @return
     */
    AllProductCateResponse getAllProductCate(AllProductCateRequest request);
}
