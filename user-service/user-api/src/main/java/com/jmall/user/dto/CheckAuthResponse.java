package com.jmall.user.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

@Data
public class CheckAuthResponse extends AbstractResponse {

    private String userinfo;
}
