package com.jmall.comment;

import com.jmall.comment.dto.*;

public interface ICommentReplyService {

    /**
     * 新增商品评价回复
     * @param request
     * @return
     */
    AddCommentReplyResponse addCommentReply(AddCommentReplyRequest request);

    /**
     * 删除商品评价回复
     * @param request
     * @return
     */
    DeleteCommentReplyResponse deleteCommentReply(DeleteCommentReplyRequest request);

    /**
     * 分页查询商品评价回复意见
     * @param request
     * @return
     */
    CommentReplyListResponse commentReplyList(CommentReplyListRequest request);
}
