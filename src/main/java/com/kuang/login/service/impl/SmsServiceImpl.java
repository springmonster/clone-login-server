package com.kuang.login.service.impl;

import com.kuang.login.dto.SmsResponseDto;
import com.kuang.login.repository.CacheRepository;
import com.kuang.login.service.SmsService;
import com.kuang.login.utils.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Autowired
    private CacheRepository cacheRepository;

    @Override
    public SmsResponseDto generateSmsCode() {
        SmsResponseDto smsResponseDto = new SmsResponseDto();
        smsResponseDto.setSmsCode(SmsUtil.generateSmsCode());
        log.info("生成的验证码为{}", smsResponseDto.getSmsCode());
        return smsResponseDto;
    }

    @Override
    public void saveSmsCode(String smsCode) {
        cacheRepository.setSmsCode(smsCode);
    }

    /**
     * 1. 查询有没有对应的SMS Code
     * 1.1 如果有，则返回成功，并删除SMS Code
     * 1.2 如果没有，则返回失败
     *
     * @param smsCode
     * @return
     */
    @Override
    public boolean validateSmsCode(String smsCode) {
        String result = cacheRepository.getSmsCode(smsCode);

        if (ObjectUtils.isEmpty(result)) {
            return false;
        }

        cacheRepository.removeSmsCode(smsCode);

        return true;
    }
}
