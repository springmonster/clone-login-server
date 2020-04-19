package com.kuang.login.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheRepositoryTest {

    @Autowired
    CacheRepository cacheRepository;

    @Test
    public void setSmsCode() {
//        cacheRepository.setSmsCode("1234");
        String smsCode = cacheRepository.getSmsCode("1234");
        System.out.println(smsCode);
    }

    @Test
    public void getSmsCode() {
    }
}