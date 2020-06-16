package com.jmall.comment.dto;

import com.jmall.comment.constant.CommentRetCode;
import com.jmall.commons.result.AbstractRequest;
import com.jmall.commons.tool.exception.ValidateException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class DeleteCommentReplyRequest extends AbstractRequest {

    /**
     * 回复意见id
     */
    private String commentReplyId;

    /**
     * 删除人id
     */
    private Long userId;

    @Override
    public void requestCheck() {
        if (StringUtils.isEmpty(commentReplyId) || null == userId) {
            throw new ValidateException(CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(), CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
