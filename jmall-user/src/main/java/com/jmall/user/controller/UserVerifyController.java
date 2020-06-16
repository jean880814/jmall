package com.jmall.user.controller;

import com.jmall.commons.result.ResponseData;
import com.jmall.commons.result.ResponseUtil;
import com.jmall.commons.tool.utils.CookieUtil;
import com.jmall.user.IKaptchaService;
import com.jmall.user.IUserRegisterService;
import com.jmall.user.IUserVerifyService;
import com.jmall.user.annotation.Anoymous;
import com.jmall.user.constants.SysRetCodeConstants;
import com.jmall.user.dto.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserVerifyController {

    @Reference(timeout = 3000)
    IUserRegisterService iUserRegisterService;

    @Reference(timeout = 3000)
    IUserVerifyService iUserVerifyService;

    @Anoymous
    @GetMapping("/verify")
    public ResponseData register(@RequestParam String uuid,@RequestParam String username, HttpServletRequest request){
        if(!(StringUtils.isNotBlank(uuid) &&  StringUtils.isNotBlank(username))){
            return new ResponseUtil<>().setErrorMsg("注册序号/用户名不允许为空");
        }
        UserVerifyRequest userVerifyRequest = new UserVerifyRequest();
        userVerifyRequest.setUserName(username);
        userVerifyRequest.setUuid(uuid);
        UserVerifyResponse userVerifyResponse = iUserVerifyService.verifyMemer(userVerifyRequest);
        if(userVerifyResponse.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil().setData(null);
        }else{
            return new ResponseUtil().setData(userVerifyResponse.getMsg());
        }
    }
}
