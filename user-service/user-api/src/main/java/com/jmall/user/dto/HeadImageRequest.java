package com.jmall.user.dto;

import com.jmall.commons.result.AbstractRequest;
import lombok.Data;

@Data
public class HeadImageRequest extends AbstractRequest {
    private Long userId;
    private String imageData;

    @Override
    public void requestCheck() {

    }
}
