package com.kuang.login.service;

import com.kuang.login.dto.SmsRequestDto;
import com.kuang.login.dto.SmsResponseDto;

public interface SmsService {
    SmsResponseDto generateSmsCode(SmsRequestDto smsRequestDto);
}
