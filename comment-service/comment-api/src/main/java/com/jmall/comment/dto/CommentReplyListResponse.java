package com.jmall.comment.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class CommentReplyListResponse extends AbstractResponse {

    private long total;

    private List<CommentReplyDto> commentReplyDtoList;

    private int page;

    private int size;
}
