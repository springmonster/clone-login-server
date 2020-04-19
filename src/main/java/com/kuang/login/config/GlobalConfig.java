package com.kuang.login.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:global.properties")
@Configuration
@Getter
public class GlobalConfig {

    @Value("${sms.timeout}")
    private String smsTimeout;

    @Value("${sms.retryTimes}")
    private String smsRetryTimes;
}
