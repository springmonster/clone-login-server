package com.kuang.login.utils;

import java.util.UUID;

public class CacheUtil {
    private static final String tokenKeyPrefix = "user:token:";
    private static final String smsCodeKeyPrefix = "user:sms:";

    public static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public static String getTokenKey(String token) {
        return tokenKeyPrefix.concat(token);
    }

    public static String getSmsCodeKey(String smsCode) {
        return smsCodeKeyPrefix.concat(smsCode);
    }
}
