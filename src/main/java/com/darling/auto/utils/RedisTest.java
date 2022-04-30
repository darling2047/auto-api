package com.darling.auto.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author dll
 * @create 2021/1/6 15:16
 * @describe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void testString() {
        Long expire = redisUtil.getExpire("key01");
        log.info("key01.expire,{}",expire);
        redisUtil.set("key01","test0000",1000);
        Long expire1 = redisUtil.getExpire("key01");
        log.info("key01.expire,{}",expire1);
        Object key01 = redisUtil.get("key01");
        log.info("key01.value:{}",key01);
    }

    @Test
    public void testKey() {
        redisUtil.set("key02","time_000");
        log.info("key02.expire,{}",redisUtil.getExpire("key02"));
        redisUtil.set("key02","time_000",1000);
        log.info("key02.expire,{}",redisUtil.getExpire("key02"));
        redisUtil.setExpire("key02",100);
        log.info("key02.expire,{}",redisUtil.getExpire("key02"));
    }
}
