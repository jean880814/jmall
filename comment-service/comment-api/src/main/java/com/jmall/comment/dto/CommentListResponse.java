package com.jmall.comment.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class CommentListResponse extends AbstractResponse {

    private List<CommentDto> commentDtoList;

    private int page;

    private int size;

    private long total;
}
