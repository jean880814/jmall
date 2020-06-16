package com.jmall.coupon.dto;

import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.tool.exception.ValidateException;
import com.jmall.coupon.SaleTypeEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class CreateActiRequest extends AbstractRequest {
    private String name;
    private SaleTypeEnum saleType;
    private String desc;

    @Override
    public void requestCheck() {
        if (StringUtils.isEmpty(name)) {
            throw new ValidateException("缺少name参数");
        }
        if (saleType == null) {
            throw new ValidateException("缺少type参数");
        }
    }
}
