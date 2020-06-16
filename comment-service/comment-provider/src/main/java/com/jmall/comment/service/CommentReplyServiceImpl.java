package com.jmall.comment.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmall.comment.CommentException;
import com.jmall.comment.ICommentReplyService;
import com.jmall.comment.constant.CommentRetCode;
import com.jmall.comment.convert.CommentConverter;
import com.jmall.comment.dal.entitys.Comment;
import com.jmall.comment.dal.entitys.CommentReply;
import com.jmall.comment.dal.persistence.CommentMapper;
import com.jmall.comment.dal.persistence.CommentReplyMapper;
import com.jmall.comment.dto.*;
import com.jmall.comment.utils.ExceptionProcessorUtil;
import com.jmall.comment.utils.GlobalIdGeneratorUtil;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentReplyServiceImpl implements ICommentReplyService {

    @Autowired
    private CommentReplyMapper commentReplyMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CommentConverter commentConverter;

    @Autowired
    private GlobalIdGeneratorUtil globalIdGeneratorUtil;

    private static final String COMMENT_GLOBAL_ID_CACHE_KEY = "COMMENT_REPLY_ID";


    @Override
    public AddCommentReplyResponse addCommentReply(AddCommentReplyRequest request) {
        AddCommentReplyResponse response = new AddCommentReplyResponse();
        try {
            request.requestCheck();
            CommentReply commentReply = new CommentReply();
            String commentId = request.getCommentId();
            Comment comment = commentMapper.selectByPrimaryKey(commentId);
            if (comment != null && (comment.getIsDeleted() == null || !comment.getIsDeleted())) {
                commentReply.setCommentId(commentId);
            } else {
                CommentReply reply = commentReplyMapper.selectByPrimaryKey(commentId);
                if (reply != null) {
                    commentReply.setParentId(commentId);
                } else {
                    throw new CommentException(CommentRetCode.ORIGIN_COMMENT_NOT_EXIST.getCode(), CommentRetCode.ORIGIN_COMMENT_NOT_EXIST.getMessage());
                }
            }
            commentReply.setId(globalIdGeneratorUtil.getNextSeq(COMMENT_GLOBAL_ID_CACHE_KEY, 1));
            commentReply.setContent(request.getContent());
            commentReply.setReplyTime(new Date());
            commentReply.setReplyNick(request.getReplyNick());
            commentReply.setUserId(request.getUserId());
            commentReply.setIsDeleted(false);
            commentReplyMapper.insert(commentReply);

            response.setCode(CommentRetCode.SUCCESS.getCode());
            response.setMsg(CommentRetCode.SUCCESS.getMessage());
        } catch (Exception e) {
            ExceptionProcessorUtil.handleException(response, e);
        }
        return response;
    }

    @Override
    public DeleteCommentReplyResponse deleteCommentReply(DeleteCommentReplyRequest request) {
        DeleteCommentReplyResponse response = new DeleteCommentReplyResponse();
        try {
            request.requestCheck();
            CommentReply commentReply = commentReplyMapper.selectByPrimaryKey(request.getCommentReplyId());
            if (commentReply == null || (commentReply.getIsDeleted() != null && commentReply.getIsDeleted())) {
                throw new CommentException(CommentRetCode.CURRENT_COMMENT_REPLY_NOT_EXIST.getCode(), CommentRetCode.CURRENT_COMMENT_REPLY_NOT_EXIST.getMessage());
            }
            commentReply.setIsDeleted(true);
            commentReply.setDeletionUserId(request.getUserId());
            commentReply.setDeletionTime(new Date());
            commentReplyMapper.updateByPrimaryKey(commentReply);

            response.setCode(CommentRetCode.SUCCESS.getCode());
            response.setMsg(CommentRetCode.SUCCESS.getMessage());
        } catch (Exception e) {
            ExceptionProcessorUtil.handleException(response, e);
        }
        return response;
    }

    @Override
    public CommentReplyListResponse commentReplyList(CommentReplyListRequest request) {
        CommentReplyListResponse response = new CommentReplyListResponse();
        try {
            request.requestCheck();

            Example example = new Example(CommentReply.class);
            Example.Criteria criteria = example.createCriteria();
            CommentReply commentReply = commentReplyMapper.selectByPrimaryKey(request.getCommentId());
            if (commentReply != null) {
                criteria.andEqualTo("parentId", request.getCommentId());
            } else {
                criteria.andEqualTo("commentId", request.getCommentId());
            }
            PageHelper.startPage(request.getPage(), request.getSize());
            List<CommentReply> commentReplyList = commentReplyMapper.selectByExample(example);
            PageInfo<CommentReply> pageInfo = new PageInfo<>(commentReplyList);
            if (CollectionUtils.isEmpty(commentReplyList)) {
                response.setCommentReplyDtoList(new ArrayList<>());
            } else {
                response.setCommentReplyDtoList(commentConverter.commentReply2Dto(commentReplyList));
            }
            response.setTotal(pageInfo.getTotal());
            response.setPage(request.getPage());
            response.setSize(request.getSize());
        } catch (Exception e) {
            ExceptionProcessorUtil.handleException(response, e);
        }
        return response;
    }
}
