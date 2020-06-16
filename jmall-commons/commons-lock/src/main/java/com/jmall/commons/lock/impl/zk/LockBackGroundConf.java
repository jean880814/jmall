package com.jmall.commons.lock.impl.zk;

public class LockBackGroundConf {

    /** 执行频率, 默认一小时一次, 单位秒 */
    private Long frequency = 60*60L;
    /** 删除几天前的数据, 默认1天前的数据, 单位秒 */
    private Long beforeTime = 24*60*60L;


    public Long getFrequency() {
        return frequency;
    }
    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }
    public Long getBeforeTime() {
        return beforeTime;
    }
    public void setBeforeTime(Long beforeTime) {
        this.beforeTime = beforeTime;
    }
}
