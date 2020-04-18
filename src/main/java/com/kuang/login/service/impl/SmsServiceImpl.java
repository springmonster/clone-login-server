package com.kuang.login.service.impl;

import com.kuang.login.dto.SmsRequestDto;
import com.kuang.login.dto.SmsResponseDto;
import com.kuang.login.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Override
    public SmsResponseDto generateSmsCode(SmsRequestDto smsRequestDto) {
        SmsResponseDto smsResponseDto = new SmsResponseDto();
        smsResponseDto.setSmsCode(String.valueOf((int) ((Math.random() * 9 + 1) * 1000)));
        log.info("生成的验证码为{}", smsResponseDto.getSmsCode());
        return smsResponseDto;
    }
}
