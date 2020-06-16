package com.jmall.coupon;

import com.jmall.coupon.dto.CreateActiRequest;
import com.jmall.coupon.dto.CreateActiResponse;

public interface IActivityCoreService {
    // 创建营销活动
    CreateActiResponse create(CreateActiRequest request);
    // 修改活动
    void update();
    // 删除活动
    void delete();
}
