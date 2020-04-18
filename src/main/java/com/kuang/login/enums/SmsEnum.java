package com.kuang.login.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SmsEnum {

    SMS_SEND_SUCCESS(HttpStatus.OK.value(), "发送SMS成功"),
    SMS_SEND_FAIL(HttpStatus.BAD_REQUEST.value(), "发送SMS失败");

    private final int code;
    private final String msg;

    SmsEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}