package com.jmall.order.biz.callback;

import com.jmall.order.biz.context.TransHandlerContext;

public interface TransCallback {

    void onDone(TransHandlerContext context);
}
