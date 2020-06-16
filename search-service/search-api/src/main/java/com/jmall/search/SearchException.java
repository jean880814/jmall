package com.jmall.search;


import com.jmall.commons.tool.exception.BaseBusinessException;

public class SearchException extends BaseBusinessException {
    public SearchException() {
    }

    public SearchException(String errorCode) {
        super(errorCode);
    }

    public SearchException(String errorCode, String message) {
        super(errorCode, message);
    }

    public static SearchException create(String errorCode, String message) {
        return new SearchException(errorCode, message);
    }
}
