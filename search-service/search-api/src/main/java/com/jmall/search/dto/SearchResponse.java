package com.jmall.search.dto;


import com.jmall.commons.result.AbstractResponse;
import com.jmall.search.consts.SearchRetCode;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponse<T> extends AbstractResponse {
     private Long total;
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public SearchResponse setData(List<T> data) {
        this.data = data;
        return this;
    }

    public SearchResponse ok(List<T> data) {
        this.setCode(SearchRetCode.SUCCESS.getCode());
        this.setMsg(SearchRetCode.SUCCESS.getMsg());
        this.setTotal(total);
        this.setData(data);
        return this;
    }
}
