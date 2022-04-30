package com.darling.auto.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author dll
 * @create 2021/1/6 15:20
 * @describe
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    private final String KEY_PREFIX = "DARLING_";

    /****************************************** String相关操作 **********************************************/

    /**
     * 设置包含过期时间的k v
     *
     * @param key
     * @param value
     * @param expire 期望redis保留的时长  单位:秒
     */
    public void set(String key, Object value, long expire) {
        redisTemplate.opsForValue().set(KEY_PREFIX+key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * 设置k v
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(KEY_PREFIX+key, value);
    }

    /**
     * 获取指定key的value
     * @param key
     * @return
     */
    public Object get(String key) {
        Object o = redisTemplate.opsForValue().get(KEY_PREFIX+key);
        return o;
    }

    /**
     * 针对整形的value递减1
     * @param key
     * @return 递减后的value
     */
    public Long decrement (String key) {
        Long decrement = redisTemplate.opsForValue().decrement(KEY_PREFIX+key);
        return decrement;
    }

    /**
     * 针对整形的value递减指定数值
     * @param key
     * @return 递减后的value
     */
    public Long decrement (String key,long diff) {
        Long decrement = redisTemplate.opsForValue().decrement(KEY_PREFIX+key,diff);
        return decrement;
    }

    /**
     * 针对整形的value递增1
     * @param key
     * @return 递增后的value
     */
    public Long increment (String key) {
        Long decrement = redisTemplate.opsForValue().increment(KEY_PREFIX+key);
        return decrement;
    }

    /**
     * 针对整形的value递增指定数值
     * @param key
     * @return 递增后的value
     */
    public Long increment (String key,long diff) {
        Long decrement = redisTemplate.opsForValue().increment(KEY_PREFIX+key,diff);
        return decrement;
    }

    /****************************************** KEY相关操作 **********************************************/

    /**
     * 获取key的过期时间
     * @param key
     * @return
     */
    public Long getExpire(String key) {
        Long expire = redisTemplate.getExpire(KEY_PREFIX+key);
        return expire;
    }

    public Boolean setExpire(String key,long expire) {
        Boolean aBoolean = redisTemplate.expire(KEY_PREFIX + key, expire, TimeUnit.SECONDS);
        return aBoolean;
    }

    public void setBit () {
        redisTemplate.opsForValue().setBit("zhangsan",0,true);
    }
}
