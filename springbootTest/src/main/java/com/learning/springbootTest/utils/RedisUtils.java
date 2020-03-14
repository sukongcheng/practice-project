package com.learning.springbootTest.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@SuppressWarnings("all")
public class RedisUtils {

    final String a = "";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 获取键过期时间
     */
    public long ttl(String key, TimeUnit timeUnit){
        return stringRedisTemplate.getExpire(key, timeUnit);
    }

    /**
     * 设置键过期时间
     */
    public boolean expire(String key, long timeout, TimeUnit timeUnit){
        return stringRedisTemplate.expire(key, timeout, timeUnit);
    }

    /**
     * 获取旧值并更新值
     */
    public String getSet(String key, String value){
        return stringRedisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * 删除
     */
    public boolean del(String key){
        return stringRedisTemplate.delete(key);
    }

    /**
     * 将哈希表 key 中的域 field 的值设为 value
     */
    public void hset(String key, String field, String value){
        stringRedisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 返回哈希表 key 中给定域 field 的值
     */
    public String hget(String key, String field){
        return (String) stringRedisTemplate.opsForHash().get(key, field);
    }
}
