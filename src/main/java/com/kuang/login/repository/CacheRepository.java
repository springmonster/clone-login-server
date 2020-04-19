package com.kuang.login.repository;

import com.kuang.login.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class CacheRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    public String setAndReturnUserToken() {
        String userTokenValue = RedisUtil.generateToken();
        String userTokenKey = RedisUtil.getTokenKey(userTokenValue);
        redisTemplate.opsForValue().set(userTokenKey, userTokenValue, 30, TimeUnit.DAYS);
        return userTokenValue;
    }

    public String getUserToken(String token) {
        String userTokenKey = RedisUtil.getTokenKey(token);
        return redisTemplate.opsForValue().get(userTokenKey).toString();
    }

    public void setSmsCode(String smsCode) {
        String smsCodeKey = RedisUtil.getSmsCodeKey(smsCode);
        redisTemplate.opsForValue().set(smsCodeKey, smsCode, 60, TimeUnit.SECONDS);
    }

    public String getSmsCode(String smsCode) {
        String smsCodeKey = RedisUtil.getSmsCodeKey(smsCode);
        return (String) redisTemplate.opsForValue().get(smsCodeKey);
    }

    public Boolean removeSmsCode(String smsCode) {
        String smsCodeKey = RedisUtil.getSmsCodeKey(smsCode);
        return redisTemplate.delete(smsCodeKey);
    }
}
