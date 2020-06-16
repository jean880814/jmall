package com.jmall.user.dto;

import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.tool.exception.ValidateException;
import com.jmall.user.constants.SysRetCodeConstants;
import lombok.Data;

@Data
public class DeleteAddressRequest extends AbstractRequest {
    private Long addressId;

    @Override
    public void requestCheck() {
        if(addressId==null) {
            throw new ValidateException(
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
