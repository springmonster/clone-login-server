package com.kuang.login.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheUtilTest {

    @Test
    public void generateTokenKey() {
        String token = CacheUtil.generateToken();
        String redisKey = CacheUtil.getTokenKey(token);
        System.out.println(redisKey);
    }
}