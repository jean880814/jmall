package com.jmall.comment.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class CommentResponse extends AbstractResponse {

    private List<CommentDto> commentDtoList;
}
