package com.jmall.coupon.strategy;

import com.jmall.coupon.dto.UseCouponRequest;

public abstract class SaleStrategy {
    public abstract boolean match(UseCouponRequest request);
    public abstract void perform();
}
