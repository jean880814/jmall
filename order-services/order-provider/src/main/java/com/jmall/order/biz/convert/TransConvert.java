
package com.jmall.order.biz.convert;


import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.result.AbstractResponse;
import com.jmall.order.biz.context.TransHandlerContext;

public interface TransConvert {
    /**
     * 请求转上下文
     * 
     * @param req
     * @return
     */
    TransHandlerContext convertRequest2Ctx(AbstractRequest req, TransHandlerContext context);
    
    /**
     * 上下文转应答
     * 
     * @param ctx
     * @return
     */
    AbstractResponse convertCtx2Respond(TransHandlerContext ctx);
}
