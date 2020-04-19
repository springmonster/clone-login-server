package com.kuang.login.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisUtilTest {

    @Test
    public void generateTokenKey() {
        String token = RedisUtil.generateToken();
        String redisKey = RedisUtil.getTokenKey(token);
        System.out.println(redisKey);
    }
}