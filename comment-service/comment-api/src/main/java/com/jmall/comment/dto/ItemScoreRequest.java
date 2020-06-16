package com.jmall.comment.dto;

import com.jmall.comment.constant.CommentRetCode;
import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.tool.exception.ValidateException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class ItemScoreRequest extends AbstractRequest {

    /**
     * 商品id
     */
    private String itemId;

    @Override
    public void requestCheck() {
        if (StringUtils.isEmpty(itemId)) {
            throw new ValidateException(CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
