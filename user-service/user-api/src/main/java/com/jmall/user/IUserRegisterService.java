package com.jmall.user;

import com.jmall.user.dto.UserRegisterRequest;
import com.jmall.user.dto.UserRegisterResponse;

public interface IUserRegisterService {

    /**
     * 实现用户注册功能
     * @param request
     * @return
     */
    UserRegisterResponse register(UserRegisterRequest request);
}
