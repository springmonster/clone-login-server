package com.kuang.login.service;

import com.kuang.login.dto.SmsResponseDto;

public interface SmsService {

    SmsResponseDto generateSmsCode();

    void saveSmsCode(String smsCode);

    boolean validateSmsCode(String smsCode);
}
