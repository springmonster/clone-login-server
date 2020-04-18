package com.kuang.login.service.impl;

import com.kuang.login.dto.SmsRequestDto;
import com.kuang.login.service.SmsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LoginServiceImplTest {
    @Autowired
    private SmsService smsService;

    @Test
    public void generateSmsCode() {
        assertEquals(4, smsService.generateSmsCode(new SmsRequestDto()).getSmsCode().length());
    }
}