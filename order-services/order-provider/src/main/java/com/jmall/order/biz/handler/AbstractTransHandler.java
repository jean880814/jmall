package com.jmall.order.biz.handler;

import com.jmall.order.biz.callback.TransCallback;
import lombok.Data;

@Data
public abstract class AbstractTransHandler implements TransHandler {

    public static final String DEFAULT = "default";

    public TransCallback getTransCallback(){return null;}
}
