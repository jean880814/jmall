package com.jmall.comment.dto;

import com.jmall.comment.constant.CommentRetCode;
import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.tool.exception.ValidateException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class CommentReplyListRequest extends AbstractRequest {

    /**
     * 商品评价id或者回复意见id
     */
    private String commentId;

    private int page;

    private int size;

    @Override
    public void requestCheck() {
        if (StringUtils.isEmpty(commentId)) {
            throw new ValidateException(CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
        if (page < 1) {
            setPage(1);
        }
        if (size < 1) {
            size = 10;
        }
    }
}
