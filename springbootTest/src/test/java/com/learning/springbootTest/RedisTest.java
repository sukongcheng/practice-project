package com.learning.springbootTest;

import com.learning.springbootTest.entity.User;
import com.learning.springbootTest.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = SpringbootTestApplication.class)
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void setGetTest() {
        redisUtils.set("name", "Tom");
        System.out.println(redisUtils.get("name"));
        redisUtils.del("name");
    }

    @Test
    public void delTest() {
        redisUtils.set("name", "Tom");
        redisUtils.del("name");
        System.out.println(redisUtils.get("name"));
    }

    @Test
    public void updateTest() {
        redisUtils.set("name", "Tom");
        redisUtils.getSet("name", "DiJa");
        System.out.println(redisUtils.get("name"));
    }

    @Test
    public void timeoutTest() {
        redisUtils.set("name", "Tom");
        redisUtils.expire("name", 10000, TimeUnit.MILLISECONDS);
        System.out.println(redisUtils.ttl("name", TimeUnit.MILLISECONDS));
        redisUtils.del("name");
    }

    @Test
    public void hgetAndHsetTest() {
        redisUtils.hset("shi", "yan", "lou");
        System.out.println(redisUtils.hget("shi", "yan"));
        redisUtils.del("shi");
    }


    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void addUserToRedis() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        redisTemplate.opsForValue().set("zhangsan", user);
//        System.out.println((User) redisTemplate.opsForValue().get("张三"));
//        redisTemplate.delete("张三");
    }


}
