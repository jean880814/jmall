package com.jmall.order.biz.handler;

import com.jmall.commons.tool.exception.BizException;
import com.jmall.order.biz.context.CreateOrderContext;
import com.jmall.order.biz.context.TransHandlerContext;
import com.jmall.order.constant.OrderRetCode;
import com.jmall.order.dal.persistence.OrderMapper;
import com.jmall.user.IMemberService;
import com.jmall.user.dto.QueryMemberRequest;
import com.jmall.user.dto.QueryMemberResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidateHandler extends AbstractTransHandler {

    @Autowired
    OrderMapper orderMapper;

    @Reference(mock = "com.jmall.order.biz.mock.MockMemberService",check = false)
    IMemberService memberService;

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean handle(TransHandlerContext context) {
        log.info("begin ValidateHandler :context:"+context);
        CreateOrderContext createOrderContext=(CreateOrderContext)context;
        QueryMemberRequest queryMemberRequest =new QueryMemberRequest();
        queryMemberRequest.setUserId(createOrderContext.getUserId());
        QueryMemberResponse response=memberService.queryMemberById(queryMemberRequest);
        if(OrderRetCode.SUCCESS.getCode().equals(response.getCode())){
            createOrderContext.setBuyerNickName(response.getUsername());
        }else{
            throw new BizException(response.getCode(),response.getMsg());
        }
        return true;
    }
}
