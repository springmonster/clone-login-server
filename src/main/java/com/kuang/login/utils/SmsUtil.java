package com.kuang.login.utils;

public class SmsUtil {

    public static String generateSmsCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
    }
}
