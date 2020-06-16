package com.jmall.user.bootstrap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @program: jmall
 * @author: Jean
 * @create: 2020-04-30 13:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void test(){
        RBucket rBucket = redissonClient.getBucket("test");
        rBucket.set("test");
        rBucket.expire(60, TimeUnit.SECONDS);
    }
}
