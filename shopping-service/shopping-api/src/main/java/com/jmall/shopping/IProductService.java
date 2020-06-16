package com.jmall.shopping;

import com.jmall.shopping.dto.*;

public interface IProductService {

    /**
     * 查看商品明细
     * @param request
     * @return
     */
    ProductDetailResponse getProductDetail(ProductDetailRequest request);

    /**
     * 查询所有商品（分页）
     * @param request
     * @return
     */
    AllProductResponse getAllProduct(AllProductRequest request);

    /**
     * 获取推荐的商品板块
     * @return
     */
    RecommendResponse getRecommendGoods();

}
