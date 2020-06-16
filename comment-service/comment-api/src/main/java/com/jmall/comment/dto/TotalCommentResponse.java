package com.jmall.comment.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

@Data
public class TotalCommentResponse extends AbstractResponse {

    private long total;
}
