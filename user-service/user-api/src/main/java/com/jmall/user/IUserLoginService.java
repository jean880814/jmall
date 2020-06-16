package com.jmall.user;

import com.jmall.user.dto.CheckAuthRequest;
import com.jmall.user.dto.CheckAuthResponse;
import com.jmall.user.dto.UserLoginRequest;
import com.jmall.user.dto.UserLoginResponse;

public interface IUserLoginService {

    /**
     * 用户登录
     * @param request
     * @return
     */
    UserLoginResponse login(UserLoginRequest request);


    /**
     * 校验过程
     * @param request
     * @return
     */
    CheckAuthResponse validToken(CheckAuthRequest request);
}
