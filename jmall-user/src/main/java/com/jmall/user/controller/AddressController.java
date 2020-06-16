package com.jmall.user.controller;

import com.jmall.commons.result.ResponseData;
import com.jmall.commons.result.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {


    /**
     * 获取地址列表信息
     * @return
     */
    @GetMapping("/address")
    public ResponseData address(){
        return new ResponseUtil<>().setData(null);
    }


}
