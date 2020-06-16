package com.jmall.comment;


import com.jmall.commons.tool.exception.BaseBusinessException;

public class CommentException extends BaseBusinessException {

    public CommentException() {
    }

    public CommentException(String errorCode) {
        super(errorCode);
    }

    public CommentException(String errorCode, String message) {
        super(errorCode, message);
    }
}
