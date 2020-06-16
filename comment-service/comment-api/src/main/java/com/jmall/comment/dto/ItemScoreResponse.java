package com.jmall.comment.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;
@Data
public class ItemScoreResponse extends AbstractResponse {

    /**
     * 综合评分
     */
    private double score;
}
