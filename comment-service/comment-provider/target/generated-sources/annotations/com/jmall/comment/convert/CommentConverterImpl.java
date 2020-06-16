package com.jmall.comment.convert;

import com.jmall.comment.dal.entitys.Comment;
import com.jmall.comment.dal.entitys.CommentReply;
import com.jmall.comment.dto.CommentDto;
import com.jmall.comment.dto.CommentReplyDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-12T13:12:23+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class CommentConverterImpl implements CommentConverter {

    @Override
    public CommentDto comment2Dto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setId( comment.getId() );
        commentDto.setOrderId( comment.getOrderId() );
        commentDto.setItemId( comment.getItemId() );
        commentDto.setStar( comment.getStar() );
        commentDto.setType( comment.getType() );
        commentDto.setIsAnoymous( comment.getIsAnoymous() );
        commentDto.setContent( comment.getContent() );
        commentDto.setBuyerNick( comment.getBuyerNick() );
        commentDto.setCommentTime( comment.getCommentTime() );
        commentDto.setIsPublic( comment.getIsPublic() );
        commentDto.setIsValid( comment.getIsValid() );
        commentDto.setValidationUserId( comment.getValidationUserId() );
        commentDto.setValidationTime( comment.getValidationTime() );
        commentDto.setValidationSuggestion( comment.getValidationSuggestion() );
        commentDto.setIsTop( comment.getIsTop() );
        commentDto.setUserId( comment.getUserId() );
        commentDto.setIsDeleted( comment.getIsDeleted() );
        commentDto.setDeletionTime( comment.getDeletionTime() );
        commentDto.setDeletionUserId( comment.getDeletionUserId() );

        return commentDto;
    }

    @Override
    public List<CommentDto> comment2Dto(List<Comment> commentList) {
        if ( commentList == null ) {
            return null;
        }

        List<CommentDto> list = new ArrayList<CommentDto>( commentList.size() );
        for ( Comment comment : commentList ) {
            list.add( comment2Dto( comment ) );
        }

        return list;
    }

    @Override
    public CommentReplyDto commentReply2Dto(CommentReply commentReply) {
        if ( commentReply == null ) {
            return null;
        }

        CommentReplyDto commentReplyDto = new CommentReplyDto();

        commentReplyDto.setId( commentReply.getId() );
        commentReplyDto.setCommentId( commentReply.getCommentId() );
        commentReplyDto.setParentId( commentReply.getParentId() );
        commentReplyDto.setContent( commentReply.getContent() );
        commentReplyDto.setReplyTime( commentReply.getReplyTime() );
        commentReplyDto.setReplyNick( commentReply.getReplyNick() );
        commentReplyDto.setUserId( commentReply.getUserId() );
        commentReplyDto.setIsDeleted( commentReply.getIsDeleted() );
        commentReplyDto.setDeletionTime( commentReply.getDeletionTime() );
        commentReplyDto.setDeletionUserId( commentReply.getDeletionUserId() );

        return commentReplyDto;
    }

    @Override
    public List<CommentReplyDto> commentReply2Dto(List<CommentReply> commentReplyList) {
        if ( commentReplyList == null ) {
            return null;
        }

        List<CommentReplyDto> list = new ArrayList<CommentReplyDto>( commentReplyList.size() );
        for ( CommentReply commentReply : commentReplyList ) {
            list.add( commentReply2Dto( commentReply ) );
        }

        return list;
    }
}
