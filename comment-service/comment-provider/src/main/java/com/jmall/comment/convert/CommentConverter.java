package com.jmall.comment.convert;

import com.jmall.comment.dal.entitys.Comment;
import com.jmall.comment.dal.entitys.CommentReply;
import com.jmall.comment.dto.CommentDto;
import com.jmall.comment.dto.CommentReplyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentConverter {

    @Mappings({})
    CommentDto comment2Dto(Comment comment);

    List<CommentDto> comment2Dto(List<Comment> commentList);

    CommentReplyDto commentReply2Dto(CommentReply commentReply);

    List<CommentReplyDto> commentReply2Dto(List<CommentReply> commentReplyList);
}
