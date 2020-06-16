package com.jmall.user;

import com.jmall.user.dto.UserVerifyRequest;
import com.jmall.user.dto.UserVerifyResponse;

public interface IUserVerifyService {



    /**
     * 激活邮件
     * @param userVerifyRequest
     * @return
     */
    UserVerifyResponse verifyMemer(UserVerifyRequest userVerifyRequest);
}
